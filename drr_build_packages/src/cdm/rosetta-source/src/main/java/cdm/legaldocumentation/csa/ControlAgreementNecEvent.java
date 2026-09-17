package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.ControlAgreementNecEventMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.Required;
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
 * A class to specify Control Agreement language related to delivery of a Notice of Exclusive Control.
 * @version 6.23.0
 */
@RosettaDataType(value="ControlAgreementNecEvent", builder=ControlAgreementNecEvent.ControlAgreementNecEventBuilderImpl.class, version="6.23.0")
@RuneDataType(value="ControlAgreementNecEvent", model="cdm", builder=ControlAgreementNecEvent.ControlAgreementNecEventBuilderImpl.class, version="6.23.0")
public interface ControlAgreementNecEvent extends RosettaModelObject {

	ControlAgreementNecEventMeta metaData = new ControlAgreementNecEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates party specific Control Agreement language related to delivery of a Notice of Exclusive Control.
	 */
	List<? extends ControlAgreementNecEventElection> getControlAgreementNecEventElection();

	/*********************** Build Methods  ***********************/
	ControlAgreementNecEvent build();
	
	ControlAgreementNecEvent.ControlAgreementNecEventBuilder toBuilder();
	
	static ControlAgreementNecEvent.ControlAgreementNecEventBuilder builder() {
		return new ControlAgreementNecEvent.ControlAgreementNecEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ControlAgreementNecEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ControlAgreementNecEvent> getType() {
		return ControlAgreementNecEvent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("controlAgreementNecEventElection"), processor, ControlAgreementNecEventElection.class, getControlAgreementNecEventElection());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ControlAgreementNecEventBuilder extends ControlAgreementNecEvent, RosettaModelObjectBuilder {
		ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder getOrCreateControlAgreementNecEventElection(int index);
		@Override
		List<? extends ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder> getControlAgreementNecEventElection();
		ControlAgreementNecEvent.ControlAgreementNecEventBuilder addControlAgreementNecEventElection(ControlAgreementNecEventElection controlAgreementNecEventElection);
		ControlAgreementNecEvent.ControlAgreementNecEventBuilder addControlAgreementNecEventElection(ControlAgreementNecEventElection controlAgreementNecEventElection, int idx);
		ControlAgreementNecEvent.ControlAgreementNecEventBuilder addControlAgreementNecEventElection(List<? extends ControlAgreementNecEventElection> controlAgreementNecEventElection);
		ControlAgreementNecEvent.ControlAgreementNecEventBuilder setControlAgreementNecEventElection(List<? extends ControlAgreementNecEventElection> controlAgreementNecEventElection);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("controlAgreementNecEventElection"), processor, ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder.class, getControlAgreementNecEventElection());
		}
		

		ControlAgreementNecEvent.ControlAgreementNecEventBuilder prune();
	}

	/*********************** Immutable Implementation of ControlAgreementNecEvent  ***********************/
	class ControlAgreementNecEventImpl implements ControlAgreementNecEvent {
		private final List<? extends ControlAgreementNecEventElection> controlAgreementNecEventElection;
		
		protected ControlAgreementNecEventImpl(ControlAgreementNecEvent.ControlAgreementNecEventBuilder builder) {
			this.controlAgreementNecEventElection = ofNullable(builder.getControlAgreementNecEventElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("controlAgreementNecEventElection")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("controlAgreementNecEventElection")
		public List<? extends ControlAgreementNecEventElection> getControlAgreementNecEventElection() {
			return controlAgreementNecEventElection;
		}
		
		@Override
		public ControlAgreementNecEvent build() {
			return this;
		}
		
		@Override
		public ControlAgreementNecEvent.ControlAgreementNecEventBuilder toBuilder() {
			ControlAgreementNecEvent.ControlAgreementNecEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ControlAgreementNecEvent.ControlAgreementNecEventBuilder builder) {
			ofNullable(getControlAgreementNecEventElection()).ifPresent(builder::setControlAgreementNecEventElection);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ControlAgreementNecEvent _that = getType().cast(o);
		
			if (!ListEquals.listEquals(controlAgreementNecEventElection, _that.getControlAgreementNecEventElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (controlAgreementNecEventElection != null ? controlAgreementNecEventElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ControlAgreementNecEvent {" +
				"controlAgreementNecEventElection=" + this.controlAgreementNecEventElection +
			'}';
		}
	}

	/*********************** Builder Implementation of ControlAgreementNecEvent  ***********************/
	class ControlAgreementNecEventBuilderImpl implements ControlAgreementNecEvent.ControlAgreementNecEventBuilder {
	
		protected List<ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder> controlAgreementNecEventElection = new ArrayList<>();
		
		@Override
		@RosettaAttribute("controlAgreementNecEventElection")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("controlAgreementNecEventElection")
		public List<? extends ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder> getControlAgreementNecEventElection() {
			return controlAgreementNecEventElection;
		}
		
		@Override
		public ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder getOrCreateControlAgreementNecEventElection(int index) {
			if (controlAgreementNecEventElection==null) {
				this.controlAgreementNecEventElection = new ArrayList<>();
			}
			return getIndex(controlAgreementNecEventElection, index, () -> {
						ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder newControlAgreementNecEventElection = ControlAgreementNecEventElection.builder();
						return newControlAgreementNecEventElection;
					});
		}
		
		@RosettaAttribute("controlAgreementNecEventElection")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("controlAgreementNecEventElection")
		@Override
		public ControlAgreementNecEvent.ControlAgreementNecEventBuilder addControlAgreementNecEventElection(ControlAgreementNecEventElection _controlAgreementNecEventElection) {
			if (_controlAgreementNecEventElection != null) {
				this.controlAgreementNecEventElection.add(_controlAgreementNecEventElection.toBuilder());
			}
			return this;
		}
		
		@Override
		public ControlAgreementNecEvent.ControlAgreementNecEventBuilder addControlAgreementNecEventElection(ControlAgreementNecEventElection _controlAgreementNecEventElection, int idx) {
			getIndex(this.controlAgreementNecEventElection, idx, () -> _controlAgreementNecEventElection.toBuilder());
			return this;
		}
		
		@Override
		public ControlAgreementNecEvent.ControlAgreementNecEventBuilder addControlAgreementNecEventElection(List<? extends ControlAgreementNecEventElection> controlAgreementNecEventElections) {
			if (controlAgreementNecEventElections != null) {
				for (final ControlAgreementNecEventElection toAdd : controlAgreementNecEventElections) {
					this.controlAgreementNecEventElection.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("controlAgreementNecEventElection")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("controlAgreementNecEventElection")
		@Override
		public ControlAgreementNecEvent.ControlAgreementNecEventBuilder setControlAgreementNecEventElection(List<? extends ControlAgreementNecEventElection> controlAgreementNecEventElections) {
			if (controlAgreementNecEventElections == null) {
				this.controlAgreementNecEventElection = new ArrayList<>();
			} else {
				this.controlAgreementNecEventElection = controlAgreementNecEventElections.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ControlAgreementNecEvent build() {
			return new ControlAgreementNecEvent.ControlAgreementNecEventImpl(this);
		}
		
		@Override
		public ControlAgreementNecEvent.ControlAgreementNecEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ControlAgreementNecEvent.ControlAgreementNecEventBuilder prune() {
			controlAgreementNecEventElection = controlAgreementNecEventElection.stream().filter(b->b!=null).<ControlAgreementNecEventElection.ControlAgreementNecEventElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getControlAgreementNecEventElection()!=null && getControlAgreementNecEventElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ControlAgreementNecEvent.ControlAgreementNecEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ControlAgreementNecEvent.ControlAgreementNecEventBuilder o = (ControlAgreementNecEvent.ControlAgreementNecEventBuilder) other;
			
			merger.mergeRosetta(getControlAgreementNecEventElection(), o.getControlAgreementNecEventElection(), this::getOrCreateControlAgreementNecEventElection);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ControlAgreementNecEvent _that = getType().cast(o);
		
			if (!ListEquals.listEquals(controlAgreementNecEventElection, _that.getControlAgreementNecEventElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (controlAgreementNecEventElection != null ? controlAgreementNecEventElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ControlAgreementNecEventBuilder {" +
				"controlAgreementNecEventElection=" + this.controlAgreementNecEventElection +
			'}';
		}
	}
}
