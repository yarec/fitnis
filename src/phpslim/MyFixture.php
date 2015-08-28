<?php
class MyFixture
{
    private $_myValue;

    public function setMyValue($value)
    {
        $this->_myValue = (int) $value;
    }

    public function valueSuccessor()
    {
        if($this->_myValue<100){
            return $this->_myValue + 1;
        }else{
            return $this->_myValue + 10;
        }
    }
}
