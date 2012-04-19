//
//  OSNExtras.m
//  UseOSNService
//
//  Created by Luis Lopez on 26/03/12.
//  Copyright (c) 2012 Tempos 21. All rights reserved.
//

#import "OSNExtras.h"

@implementation OSNExtras

@synthesize dateReleased, dateUpdated, geographicalCoverage, geographicalGranularity, temporalCoverageFrom, temporalCoverageTo, temporalGranularity;

- (id)init
{
    self = [super init];
    if (self) {
        
    }
    return self;
}

-(OSNExtras *)initWithDictionary:(NSDictionary *)dict {
    
    if (!self) {
        self = [self init];
    }
    
    [self setDateReleased:[dict objectForKey:@"date_released"]];
    [self setDateUpdated:[dict objectForKey:@"date_updated"]];
    [self setGeographicalCoverage:[dict objectForKey:@"geographical_coverage"]];
    [self setGeographicalGranularity:[dict objectForKey:@"geographical_granularity"]];
    [self setTemporalCoverageFrom:[dict objectForKey:@"temporal_coverage-from"]];
    [self setTemporalCoverageTo:[dict objectForKey:@"temporal_coverage-to"]];
    [self setTemporalGranularity:[dict objectForKey:@"temporal_granularity"]];
    
    return self;
    
    
}
@end
