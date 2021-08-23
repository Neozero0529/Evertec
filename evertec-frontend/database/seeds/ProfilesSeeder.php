<?php

use Illuminate\Database\Seeder;
use Spatie\Permission\Models\Role;
use Spatie\Permission\Models\Permission;

class ProfilesSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        Role::create(['name' => 'SuperAdministrator']);
        
        (Role::create(['name' => 'Ordenes']))->givePermissionTo(Permission::where('name', 'like', 'Orders%')->get());
    }
}
