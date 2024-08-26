import { Carousel } from "@material-tailwind/react";

export function MyCarousel() {
  return (
    <div className="mt-6 flex h-72 justify-center">
      <Carousel className="h-full w-9/12 rounded-xl">
        <img
          src="https://assets.wfcdn.com/im/28569277/resize-h454-w2000%5Ecompr-r85/2897/289778886/build_your_outdoor_space._fall_picks_for_less_289778886.jpg"
          alt="image 1"
          className="h-full w-full object-cover"
        />
        <img
          src="https://assets.wfcdn.com/im/28569277/resize-h454-w2000%5Ecompr-r85/2897/289778886/build_your_outdoor_space._fall_picks_for_less_289778886.jpg"
          alt="image 2"
          className="h-full w-full object-cover"
        />
        <img
          src="https://assets.wfcdn.com/im/28569277/resize-h454-w2000%5Ecompr-r85/2897/289778886/build_your_outdoor_space._fall_picks_for_less_289778886.jpg"
          alt="image 3"
          className="h-full w-full object-cover"
        />
      </Carousel>
    </div>
  );
}

export default MyCarousel;
