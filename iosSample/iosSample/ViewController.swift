//
//  ViewController.swift
//  iosSample
//
//  Created by Ana Paula da Silva on 06/10/19.
//  Copyright © 2019 Ana Paula da Silva. All rights reserved.
//

import UIKit
import kommon

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        ValidationsKt.validate("5682376428", type: Type().CPF)
    }


}

