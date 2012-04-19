//
//  ValueViewController.h
//  UseOSNService
//
//  Created by Luis Lopez on 26/03/12.
//  Copyright (c) 2012 Tempos 21. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface ValueViewController : UIViewController {
    
    IBOutlet UITextView * valueTextView;
    NSString * text;
}
@property (nonatomic, strong) IBOutlet UITextView * valueTextView;
@property (nonatomic, strong) NSString * text;



@end
