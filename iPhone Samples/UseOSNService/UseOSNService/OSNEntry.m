//
//  OSNEntry.m
//  UseOSNService
//
//  Created by Luis Lopez on 26/03/12.
//  Copyright (c) 2012 Tempos 21. All rights reserved.
//

#import "OSNEntry.h"

@implementation OSNEntry 

@synthesize idEntry, sourceID, date, extraInfo, unit, value, latitude, longitude;

- (id)init 
{
    self = [super init];
    if (self) {
        
    }
    return self;
}

-(OSNEntry *)initWithDictionary:(NSDictionary *)dict {
    
    [self setIdEntry:[dict objectForKey:@"id"]];
    [self setSourceID:[dict objectForKey:@"source_id"]];
    [self setDate:[dict objectForKey:@"date"]];
    [self setExtraInfo:[dict objectForKey:@"extra_info"]];
    [self setUnit:[dict objectForKey:@"unit"]];
    [self setValue:[dict objectForKey:@"value"]];
    [self setLatitude:[dict objectForKey:@"latitude"]];
    [self setLongitude:[dict objectForKey:@"longitude"]];
    
    return self;
}

@end
