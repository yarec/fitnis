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
        return $this->_myValue + 1;
    }
}
