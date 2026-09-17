package cdm.product.template;

import cdm.observable.event.TriggerEvent;
import cdm.product.template.meta.BarrierMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * As per ISDA 2002 Definitions.
 * @version 6.23.0
 */
@RosettaDataType(value="Barrier", builder=Barrier.BarrierBuilderImpl.class, version="6.23.0")
@RuneDataType(value="Barrier", model="cdm", builder=Barrier.BarrierBuilderImpl.class, version="6.23.0")
public interface Barrier extends RosettaModelObject {

	BarrierMeta metaData = new BarrierMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A trigger level approached from beneath.
	 */
	List<? extends TriggerEvent> getBarrierCap();
	/**
	 * A trigger level approached from above.
	 */
	List<? extends TriggerEvent> getBarrierFloor();

	/*********************** Build Methods  ***********************/
	Barrier build();
	
	Barrier.BarrierBuilder toBuilder();
	
	static Barrier.BarrierBuilder builder() {
		return new Barrier.BarrierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Barrier> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Barrier> getType() {
		return Barrier.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("barrierCap"), processor, TriggerEvent.class, getBarrierCap());
		processRosetta(path.newSubPath("barrierFloor"), processor, TriggerEvent.class, getBarrierFloor());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BarrierBuilder extends Barrier, RosettaModelObjectBuilder {
		TriggerEvent.TriggerEventBuilder getOrCreateBarrierCap(int index);
		@Override
		List<? extends TriggerEvent.TriggerEventBuilder> getBarrierCap();
		TriggerEvent.TriggerEventBuilder getOrCreateBarrierFloor(int index);
		@Override
		List<? extends TriggerEvent.TriggerEventBuilder> getBarrierFloor();
		Barrier.BarrierBuilder addBarrierCap(TriggerEvent barrierCap);
		Barrier.BarrierBuilder addBarrierCap(TriggerEvent barrierCap, int idx);
		Barrier.BarrierBuilder addBarrierCap(List<? extends TriggerEvent> barrierCap);
		Barrier.BarrierBuilder setBarrierCap(List<? extends TriggerEvent> barrierCap);
		Barrier.BarrierBuilder addBarrierFloor(TriggerEvent barrierFloor);
		Barrier.BarrierBuilder addBarrierFloor(TriggerEvent barrierFloor, int idx);
		Barrier.BarrierBuilder addBarrierFloor(List<? extends TriggerEvent> barrierFloor);
		Barrier.BarrierBuilder setBarrierFloor(List<? extends TriggerEvent> barrierFloor);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("barrierCap"), processor, TriggerEvent.TriggerEventBuilder.class, getBarrierCap());
			processRosetta(path.newSubPath("barrierFloor"), processor, TriggerEvent.TriggerEventBuilder.class, getBarrierFloor());
		}
		

		Barrier.BarrierBuilder prune();
	}

	/*********************** Immutable Implementation of Barrier  ***********************/
	class BarrierImpl implements Barrier {
		private final List<? extends TriggerEvent> barrierCap;
		private final List<? extends TriggerEvent> barrierFloor;
		
		protected BarrierImpl(Barrier.BarrierBuilder builder) {
			this.barrierCap = ofNullable(builder.getBarrierCap()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.barrierFloor = ofNullable(builder.getBarrierFloor()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("barrierCap")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("barrierCap")
		public List<? extends TriggerEvent> getBarrierCap() {
			return barrierCap;
		}
		
		@Override
		@RosettaAttribute("barrierFloor")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("barrierFloor")
		public List<? extends TriggerEvent> getBarrierFloor() {
			return barrierFloor;
		}
		
		@Override
		public Barrier build() {
			return this;
		}
		
		@Override
		public Barrier.BarrierBuilder toBuilder() {
			Barrier.BarrierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Barrier.BarrierBuilder builder) {
			ofNullable(getBarrierCap()).ifPresent(builder::setBarrierCap);
			ofNullable(getBarrierFloor()).ifPresent(builder::setBarrierFloor);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Barrier _that = getType().cast(o);
		
			if (!ListEquals.listEquals(barrierCap, _that.getBarrierCap())) return false;
			if (!ListEquals.listEquals(barrierFloor, _that.getBarrierFloor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (barrierCap != null ? barrierCap.hashCode() : 0);
			_result = 31 * _result + (barrierFloor != null ? barrierFloor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Barrier {" +
				"barrierCap=" + this.barrierCap + ", " +
				"barrierFloor=" + this.barrierFloor +
			'}';
		}
	}

	/*********************** Builder Implementation of Barrier  ***********************/
	class BarrierBuilderImpl implements Barrier.BarrierBuilder {
	
		protected List<TriggerEvent.TriggerEventBuilder> barrierCap = new ArrayList<>();
		protected List<TriggerEvent.TriggerEventBuilder> barrierFloor = new ArrayList<>();
		
		@Override
		@RosettaAttribute("barrierCap")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("barrierCap")
		public List<? extends TriggerEvent.TriggerEventBuilder> getBarrierCap() {
			return barrierCap;
		}
		
		@Override
		public TriggerEvent.TriggerEventBuilder getOrCreateBarrierCap(int index) {
			if (barrierCap==null) {
				this.barrierCap = new ArrayList<>();
			}
			return getIndex(barrierCap, index, () -> {
						TriggerEvent.TriggerEventBuilder newBarrierCap = TriggerEvent.builder();
						return newBarrierCap;
					});
		}
		
		@Override
		@RosettaAttribute("barrierFloor")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("barrierFloor")
		public List<? extends TriggerEvent.TriggerEventBuilder> getBarrierFloor() {
			return barrierFloor;
		}
		
		@Override
		public TriggerEvent.TriggerEventBuilder getOrCreateBarrierFloor(int index) {
			if (barrierFloor==null) {
				this.barrierFloor = new ArrayList<>();
			}
			return getIndex(barrierFloor, index, () -> {
						TriggerEvent.TriggerEventBuilder newBarrierFloor = TriggerEvent.builder();
						return newBarrierFloor;
					});
		}
		
		@RosettaAttribute("barrierCap")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("barrierCap")
		@Override
		public Barrier.BarrierBuilder addBarrierCap(TriggerEvent _barrierCap) {
			if (_barrierCap != null) {
				this.barrierCap.add(_barrierCap.toBuilder());
			}
			return this;
		}
		
		@Override
		public Barrier.BarrierBuilder addBarrierCap(TriggerEvent _barrierCap, int idx) {
			getIndex(this.barrierCap, idx, () -> _barrierCap.toBuilder());
			return this;
		}
		
		@Override
		public Barrier.BarrierBuilder addBarrierCap(List<? extends TriggerEvent> barrierCaps) {
			if (barrierCaps != null) {
				for (final TriggerEvent toAdd : barrierCaps) {
					this.barrierCap.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("barrierCap")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("barrierCap")
		@Override
		public Barrier.BarrierBuilder setBarrierCap(List<? extends TriggerEvent> barrierCaps) {
			if (barrierCaps == null) {
				this.barrierCap = new ArrayList<>();
			} else {
				this.barrierCap = barrierCaps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("barrierFloor")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("barrierFloor")
		@Override
		public Barrier.BarrierBuilder addBarrierFloor(TriggerEvent _barrierFloor) {
			if (_barrierFloor != null) {
				this.barrierFloor.add(_barrierFloor.toBuilder());
			}
			return this;
		}
		
		@Override
		public Barrier.BarrierBuilder addBarrierFloor(TriggerEvent _barrierFloor, int idx) {
			getIndex(this.barrierFloor, idx, () -> _barrierFloor.toBuilder());
			return this;
		}
		
		@Override
		public Barrier.BarrierBuilder addBarrierFloor(List<? extends TriggerEvent> barrierFloors) {
			if (barrierFloors != null) {
				for (final TriggerEvent toAdd : barrierFloors) {
					this.barrierFloor.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("barrierFloor")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("barrierFloor")
		@Override
		public Barrier.BarrierBuilder setBarrierFloor(List<? extends TriggerEvent> barrierFloors) {
			if (barrierFloors == null) {
				this.barrierFloor = new ArrayList<>();
			} else {
				this.barrierFloor = barrierFloors.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Barrier build() {
			return new Barrier.BarrierImpl(this);
		}
		
		@Override
		public Barrier.BarrierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Barrier.BarrierBuilder prune() {
			barrierCap = barrierCap.stream().filter(b->b!=null).<TriggerEvent.TriggerEventBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			barrierFloor = barrierFloor.stream().filter(b->b!=null).<TriggerEvent.TriggerEventBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBarrierCap()!=null && getBarrierCap().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBarrierFloor()!=null && getBarrierFloor().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Barrier.BarrierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Barrier.BarrierBuilder o = (Barrier.BarrierBuilder) other;
			
			merger.mergeRosetta(getBarrierCap(), o.getBarrierCap(), this::getOrCreateBarrierCap);
			merger.mergeRosetta(getBarrierFloor(), o.getBarrierFloor(), this::getOrCreateBarrierFloor);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Barrier _that = getType().cast(o);
		
			if (!ListEquals.listEquals(barrierCap, _that.getBarrierCap())) return false;
			if (!ListEquals.listEquals(barrierFloor, _that.getBarrierFloor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (barrierCap != null ? barrierCap.hashCode() : 0);
			_result = 31 * _result + (barrierFloor != null ? barrierFloor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BarrierBuilder {" +
				"barrierCap=" + this.barrierCap + ", " +
				"barrierFloor=" + this.barrierFloor +
			'}';
		}
	}
}
