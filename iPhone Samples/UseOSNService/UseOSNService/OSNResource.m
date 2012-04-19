//
//  OSNResource.m
//  UseOSNService
//
//  Created by Luis Lopez on 26/03/12.
//  Copyright (c) 2012 Tempos 21. All rights reserved.
//

#import "OSNResource.h"

@implementation OSNResource 

@synthesize url, description, format;

- (id)init
{
    self = [super init];
    if (self) {
        
    }
    return self;
}

-(OSNResource *)initWithDictionary:(NSDictionary *) dict {
    
    if (!self) {
        self = [self init];
    }
    
    [self setUrl:[dict objectForKey:@"url"]];
    [self setDescription:[dict objectForKey:@"description"]];
    [self setFormat:[dict objectForKey:@"format"]];
    
    return self;
}

@end
