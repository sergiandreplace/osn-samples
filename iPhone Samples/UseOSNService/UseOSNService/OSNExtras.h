//
//  OSNExtras.h
//  UseOSNService
//
//  Created by Luis Lopez on 26/03/12.
//  Copyright (c) 2012 Tempos 21. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface OSNExtras : NSObject {
    
    NSString * dateReleased;
    NSString * dateUpdated;
    NSString * geographicalCoverage;
    NSString * geographicalGranularity;
    NSString * temporalCoverageFrom;
    NSString * temporalCoverageTo;
    NSString * temporalGranularity;
    
}

@property (nonatomic, strong) NSString * dateReleased;
@property (nonatomic, strong) NSString * dateUpdated;
@property (nonatomic, strong) NSString * geographicalCoverage;
@property (nonatomic, strong) NSString * geographicalGranularity;
@property (nonatomic, strong) NSString * temporalCoverageFrom;
@property (nonatomic, strong) NSString * temporalCoverageTo;
@property (nonatomic, strong) NSString * temporalGranularity;

-(OSNExtras *)initWithDictionary:(NSDictionary *)dict;

@end
