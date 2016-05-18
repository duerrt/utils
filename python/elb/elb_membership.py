#!/usr/bin/python
import argparse
import sys
import boto.ec2.elb
import boto

""" add or remove an instance from an elb
    requires a valid AWS profile

"""
def parse_args():
    parser = argparse.ArgumentParser()
    parser.add_argument('-a', required=True, choices=['add', 'remove'], help="ELB action")
    parser.add_argument('-p',  required=True,  help="Name of AWS credentials profile")
    parser.add_argument('-e',  nargs='*',  help="One or more ELB names")
    args = parser.parse_args()
    return {'action': args.a, 'elb': args.e, 'profile': args.p}

def get_instance_Id():
    try:
        ec2 = boto.connect_ec2()
        return boto.utils.get_instance_metadata(timeout=1, num_retries=1)['instance-id']
    except:
        print "Can't retrieve EC2 metadata"
        sys.exit(0)

def get_elb_connection(prof_name):
    return boto.ec2.elb.connect_to_region('us-east-1', profile_name=prof_name)

def remove_instance_from_ELBs(profile_name, elb_names):
    instance_list = [get_instance_Id()]
    elbConn = get_elb_connection(profile_name)
    for e in elb_names:
        print "removing %s from ELB %s " % (get_instance_Id(), e)
        stat = elbConn.deregister_instances(e, instance_list)
        print "Remove status is %s " % stat

def add_instance_to_ELBs(profile_name, elb_names):
    # find the current instance id
    instance_list = [get_instance_Id()]

    elbConn = get_elb_connection(profile_name)
    for e in elb_names:
        print "adding %s from ELB %s " % (get_instance_Id(), e)
        stat = elbConn.register_instances(e,instance_list)
        print "Status is %s " % stat

if __name__ == '__main__':
    args = parse_args()

    if args['action'] == "remove":
        remove_instance_from_ELBs(args['profile'], args['elb'])
    else:
        add_instance_to_ELBs(args['profile'], args['elb'])
