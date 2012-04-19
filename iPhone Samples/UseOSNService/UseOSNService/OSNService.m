//
//  OSNService.m
//  UseOSNService
//
//  Created by Luis Lopez on 26/03/12.
//  Copyright (c) 2012 Tempos 21. All rights reserved.
//

#import "OSNService.h"

@implementation OSNService

@synthesize idService, tag, url, name, email, group, author, description, extras, latitude, longitude, license, resources, update_period, twitter_account;

- (id)init
{
    self = [super init];
    if (self) {
        
    }
    return self;
}

-(OSNService *)initWithDictionary:(NSDictionary *)dict {
    
    self = [self init];
    
    [self setIdService:[dict objectForKey:@"id"]];
    [self setGroup:[dict objectForKey:@"group"]];
    [self setDescription:[dict objectForKey:@"description"]];
    [self setLongitude:[dict objectForKey:@"longitude"]];
    [self setLatitude:[dict objectForKey:@"latitude"]];
    [self setUrl:[dict objectForKey:@"url"]];
    [self setLicense:[dict objectForKey:@"license"]];
    [self setEmail:[dict objectForKey:@"email"]];
    [self setTag:[dict objectForKey:@"id"]];
    [self setName:[dict objectForKey:@"name"]];
    [self setAuthor:[dict objectForKey:@"author"]];
    [self setTwitter_account:[dict objectForKey:@"twitter_account"]];
    [self setUpdate_period:[dict objectForKey:@"update_period"]];
    
    [self setResources:[dict objectForKey:@"resource"]];
    [self setExtras:[dict objectForKey:@"extras"]];
    
    return self;
}

@end
