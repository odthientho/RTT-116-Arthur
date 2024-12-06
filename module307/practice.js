class Polygon {
    // Constructor that takes an array of integer side lengths
    constructor(sides) {
        this.sides = sides; // Store the array of side lengths
    }

    // Method to calculate the perimeter
    perimeter() {
        return this.sides.reduce((sum, side) => sum + side, 0); // Sum up all side lengths
    }
}

function getCount(objects) {
    // var count = 0;
    // objects.forEach(
    //     obj => {
    //         if (obj.x == obj.y) count++;
    //     }
    // )
    // return count;
    return objects.filter(obj => (obj.x == obj.y)).length;
}

console.log(getCount([{x:1, y:1}, {x:2, y:1}, {x:3, y:3}, {x:4, y:3}, {x:1, y:5}]))