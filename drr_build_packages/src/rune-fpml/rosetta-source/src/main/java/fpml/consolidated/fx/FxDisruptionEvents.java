package fpml.consolidated.fx;

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
import fpml.consolidated.fx.meta.FxDisruptionEventsMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A container for the disruption event set
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A container for the disruption event set
 *
 */
@RosettaDataType(value="FxDisruptionEvents", builder=FxDisruptionEvents.FxDisruptionEventsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxDisruptionEvents", model="fpml", builder=FxDisruptionEvents.FxDisruptionEventsBuilderImpl.class, version="2.1.1")
public interface FxDisruptionEvents extends RosettaModelObject {

	FxDisruptionEventsMeta metaData = new FxDisruptionEventsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends FxDisruptionEvent> getFxDisruptionEvent();

	/*********************** Build Methods  ***********************/
	FxDisruptionEvents build();
	
	FxDisruptionEvents.FxDisruptionEventsBuilder toBuilder();
	
	static FxDisruptionEvents.FxDisruptionEventsBuilder builder() {
		return new FxDisruptionEvents.FxDisruptionEventsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxDisruptionEvents> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxDisruptionEvents> getType() {
		return FxDisruptionEvents.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fxDisruptionEvent"), processor, FxDisruptionEvent.class, getFxDisruptionEvent());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxDisruptionEventsBuilder extends FxDisruptionEvents, RosettaModelObjectBuilder {
		FxDisruptionEvent.FxDisruptionEventBuilder getOrCreateFxDisruptionEvent(int index);
		@Override
		List<? extends FxDisruptionEvent.FxDisruptionEventBuilder> getFxDisruptionEvent();
		FxDisruptionEvents.FxDisruptionEventsBuilder addFxDisruptionEvent(FxDisruptionEvent fxDisruptionEvent);
		FxDisruptionEvents.FxDisruptionEventsBuilder addFxDisruptionEvent(FxDisruptionEvent fxDisruptionEvent, int idx);
		FxDisruptionEvents.FxDisruptionEventsBuilder addFxDisruptionEvent(List<? extends FxDisruptionEvent> fxDisruptionEvent);
		FxDisruptionEvents.FxDisruptionEventsBuilder setFxDisruptionEvent(List<? extends FxDisruptionEvent> fxDisruptionEvent);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fxDisruptionEvent"), processor, FxDisruptionEvent.FxDisruptionEventBuilder.class, getFxDisruptionEvent());
		}
		

		FxDisruptionEvents.FxDisruptionEventsBuilder prune();
	}

	/*********************** Immutable Implementation of FxDisruptionEvents  ***********************/
	class FxDisruptionEventsImpl implements FxDisruptionEvents {
		private final List<? extends FxDisruptionEvent> fxDisruptionEvent;
		
		protected FxDisruptionEventsImpl(FxDisruptionEvents.FxDisruptionEventsBuilder builder) {
			this.fxDisruptionEvent = ofNullable(builder.getFxDisruptionEvent()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fxDisruptionEvent")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fxDisruptionEvent")
		public List<? extends FxDisruptionEvent> getFxDisruptionEvent() {
			return fxDisruptionEvent;
		}
		
		@Override
		public FxDisruptionEvents build() {
			return this;
		}
		
		@Override
		public FxDisruptionEvents.FxDisruptionEventsBuilder toBuilder() {
			FxDisruptionEvents.FxDisruptionEventsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxDisruptionEvents.FxDisruptionEventsBuilder builder) {
			ofNullable(getFxDisruptionEvent()).ifPresent(builder::setFxDisruptionEvent);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxDisruptionEvents _that = getType().cast(o);
		
			if (!ListEquals.listEquals(fxDisruptionEvent, _that.getFxDisruptionEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxDisruptionEvent != null ? fxDisruptionEvent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxDisruptionEvents {" +
				"fxDisruptionEvent=" + this.fxDisruptionEvent +
			'}';
		}
	}

	/*********************** Builder Implementation of FxDisruptionEvents  ***********************/
	class FxDisruptionEventsBuilderImpl implements FxDisruptionEvents.FxDisruptionEventsBuilder {
	
		protected List<FxDisruptionEvent.FxDisruptionEventBuilder> fxDisruptionEvent = new ArrayList<>();
		
		@Override
		@RosettaAttribute("fxDisruptionEvent")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fxDisruptionEvent")
		public List<? extends FxDisruptionEvent.FxDisruptionEventBuilder> getFxDisruptionEvent() {
			return fxDisruptionEvent;
		}
		
		@Override
		public FxDisruptionEvent.FxDisruptionEventBuilder getOrCreateFxDisruptionEvent(int index) {
			if (fxDisruptionEvent==null) {
				this.fxDisruptionEvent = new ArrayList<>();
			}
			return getIndex(fxDisruptionEvent, index, () -> {
						FxDisruptionEvent.FxDisruptionEventBuilder newFxDisruptionEvent = FxDisruptionEvent.builder();
						return newFxDisruptionEvent;
					});
		}
		
		@RosettaAttribute("fxDisruptionEvent")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("fxDisruptionEvent")
		@Override
		public FxDisruptionEvents.FxDisruptionEventsBuilder addFxDisruptionEvent(FxDisruptionEvent _fxDisruptionEvent) {
			if (_fxDisruptionEvent != null) {
				this.fxDisruptionEvent.add(_fxDisruptionEvent.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxDisruptionEvents.FxDisruptionEventsBuilder addFxDisruptionEvent(FxDisruptionEvent _fxDisruptionEvent, int idx) {
			getIndex(this.fxDisruptionEvent, idx, () -> _fxDisruptionEvent.toBuilder());
			return this;
		}
		
		@Override
		public FxDisruptionEvents.FxDisruptionEventsBuilder addFxDisruptionEvent(List<? extends FxDisruptionEvent> fxDisruptionEvents) {
			if (fxDisruptionEvents != null) {
				for (final FxDisruptionEvent toAdd : fxDisruptionEvents) {
					this.fxDisruptionEvent.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("fxDisruptionEvent")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("fxDisruptionEvent")
		@Override
		public FxDisruptionEvents.FxDisruptionEventsBuilder setFxDisruptionEvent(List<? extends FxDisruptionEvent> fxDisruptionEvents) {
			if (fxDisruptionEvents == null) {
				this.fxDisruptionEvent = new ArrayList<>();
			} else {
				this.fxDisruptionEvent = fxDisruptionEvents.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FxDisruptionEvents build() {
			return new FxDisruptionEvents.FxDisruptionEventsImpl(this);
		}
		
		@Override
		public FxDisruptionEvents.FxDisruptionEventsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxDisruptionEvents.FxDisruptionEventsBuilder prune() {
			fxDisruptionEvent = fxDisruptionEvent.stream().filter(b->b!=null).<FxDisruptionEvent.FxDisruptionEventBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFxDisruptionEvent()!=null && getFxDisruptionEvent().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxDisruptionEvents.FxDisruptionEventsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxDisruptionEvents.FxDisruptionEventsBuilder o = (FxDisruptionEvents.FxDisruptionEventsBuilder) other;
			
			merger.mergeRosetta(getFxDisruptionEvent(), o.getFxDisruptionEvent(), this::getOrCreateFxDisruptionEvent);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxDisruptionEvents _that = getType().cast(o);
		
			if (!ListEquals.listEquals(fxDisruptionEvent, _that.getFxDisruptionEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxDisruptionEvent != null ? fxDisruptionEvent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxDisruptionEventsBuilder {" +
				"fxDisruptionEvent=" + this.fxDisruptionEvent +
			'}';
		}
	}
}
