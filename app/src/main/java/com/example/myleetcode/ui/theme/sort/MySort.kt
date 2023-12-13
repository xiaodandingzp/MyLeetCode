package com.example.myleetcode.ui.theme.sort

object MySort {
//    快速排序
    fun quickSort(arr: ArrayList<Int>) {
        quickSort(arr, 0, arr.size - 1)
    }
    private fun quickSort(arr: ArrayList<Int>, start: Int, endPre: Int) {
        if (start < endPre) return
        val key = arr[start]
        var begin = start
        var end = endPre
        while (begin < end) {
            while (begin < end && arr[end] > key) end--
            arr[begin] = arr[end]
            while (begin < end && arr[begin] < key) begin++
            arr[end] = arr[begin]
        }
        arr[begin] = key
        quickSort(arr, start, begin - 1)
        quickSort(arr, begin + 1, endPre)
    }

    fun fastSort(arr: ArrayList<Int>) {
        fastSort(arr, 0, arr.size - 1)
    }

    private fun fastSort(arr: ArrayList<Int>, start: Int, end: Int) {
        if (start >= end) return
        var key = arr[start]
        var startTemp = start
        var endTemp = end
        while (startTemp < endTemp) {
            while (startTemp < endTemp && arr[endTemp] > key) endTemp--
            arr[startTemp] = arr[endTemp]
            while (startTemp < endTemp && arr[startTemp] < key) startTemp++
            arr[endTemp] = arr[startTemp]
        }
        arr[startTemp] = key
        fastSort(arr, 0, startTemp - 1)
        fastSort(arr, endTemp + 1, 0)
    }
}