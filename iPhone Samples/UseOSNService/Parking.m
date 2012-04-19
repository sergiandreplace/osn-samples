//
//  Parking.m
//  UseOSNService
//
//  Created by Luis Lopez on 28/03/12.
//  Copyright (c) 2012 Tempos 21. All rights reserved.
//

#import "Parking.h"

@implementation Parking 

@synthesize parkingID, latitude, longitude, adress, price;

- (id)init
{
    self = [super init];
    if (self) {
        
    }
    return self;
}

- (Parking *)initWithDiccionary:(NSDictionary *)dict {
    
    self = [self init];
    
    [self setParkingID:[dict objectForKey:@"id"]];
    [self setLatitude:[dict objectForKey:@"lat"]];
    [self setLongitude:[dict objectForKey:@"lon"]];
    [self setAdress:[dict objectForKey:@"adr"]];
    [self setPrice:[dict objectForKey:@"price"]];
    
    return self;
}

@end
