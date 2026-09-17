package fpml.consolidated.business.events;

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
import fpml.consolidated.business.events.meta.ResetCalculationDetailsMeta;
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
 * Provision A cashflow component with optional calculation details that explain how the reset value was computed.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A cashflow component with optional calculation details that explain how the reset value was computed.
 *
 */
@RosettaDataType(value="ResetCalculationDetails", builder=ResetCalculationDetails.ResetCalculationDetailsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ResetCalculationDetails", model="fpml", builder=ResetCalculationDetails.ResetCalculationDetailsBuilderImpl.class, version="2.1.1")
public interface ResetCalculationDetails extends RosettaModelObject {

	ResetCalculationDetailsMeta metaData = new ResetCalculationDetailsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The underlyer rate or price observation(s) used to compute the amount of this cashflow component.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The underlyer rate or price observation(s) used to compute the amount of this cashflow component.
	 *
	 */
	List<? extends Observation> getObservation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The calculation details used to compute the reset rate.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The calculation details used to compute the reset rate.
	 *
	 */
	ResetCalculationElements getCalculationElements();

	/*********************** Build Methods  ***********************/
	ResetCalculationDetails build();
	
	ResetCalculationDetails.ResetCalculationDetailsBuilder toBuilder();
	
	static ResetCalculationDetails.ResetCalculationDetailsBuilder builder() {
		return new ResetCalculationDetails.ResetCalculationDetailsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ResetCalculationDetails> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ResetCalculationDetails> getType() {
		return ResetCalculationDetails.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("observation"), processor, Observation.class, getObservation());
		processRosetta(path.newSubPath("calculationElements"), processor, ResetCalculationElements.class, getCalculationElements());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ResetCalculationDetailsBuilder extends ResetCalculationDetails, RosettaModelObjectBuilder {
		Observation.ObservationBuilder getOrCreateObservation(int index);
		@Override
		List<? extends Observation.ObservationBuilder> getObservation();
		ResetCalculationElements.ResetCalculationElementsBuilder getOrCreateCalculationElements();
		@Override
		ResetCalculationElements.ResetCalculationElementsBuilder getCalculationElements();
		ResetCalculationDetails.ResetCalculationDetailsBuilder addObservation(Observation observation);
		ResetCalculationDetails.ResetCalculationDetailsBuilder addObservation(Observation observation, int idx);
		ResetCalculationDetails.ResetCalculationDetailsBuilder addObservation(List<? extends Observation> observation);
		ResetCalculationDetails.ResetCalculationDetailsBuilder setObservation(List<? extends Observation> observation);
		ResetCalculationDetails.ResetCalculationDetailsBuilder setCalculationElements(ResetCalculationElements calculationElements);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("observation"), processor, Observation.ObservationBuilder.class, getObservation());
			processRosetta(path.newSubPath("calculationElements"), processor, ResetCalculationElements.ResetCalculationElementsBuilder.class, getCalculationElements());
		}
		

		ResetCalculationDetails.ResetCalculationDetailsBuilder prune();
	}

	/*********************** Immutable Implementation of ResetCalculationDetails  ***********************/
	class ResetCalculationDetailsImpl implements ResetCalculationDetails {
		private final List<? extends Observation> observation;
		private final ResetCalculationElements calculationElements;
		
		protected ResetCalculationDetailsImpl(ResetCalculationDetails.ResetCalculationDetailsBuilder builder) {
			this.observation = ofNullable(builder.getObservation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.calculationElements = ofNullable(builder.getCalculationElements()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("observation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("observation")
		public List<? extends Observation> getObservation() {
			return observation;
		}
		
		@Override
		@RosettaAttribute("calculationElements")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationElements")
		public ResetCalculationElements getCalculationElements() {
			return calculationElements;
		}
		
		@Override
		public ResetCalculationDetails build() {
			return this;
		}
		
		@Override
		public ResetCalculationDetails.ResetCalculationDetailsBuilder toBuilder() {
			ResetCalculationDetails.ResetCalculationDetailsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ResetCalculationDetails.ResetCalculationDetailsBuilder builder) {
			ofNullable(getObservation()).ifPresent(builder::setObservation);
			ofNullable(getCalculationElements()).ifPresent(builder::setCalculationElements);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ResetCalculationDetails _that = getType().cast(o);
		
			if (!ListEquals.listEquals(observation, _that.getObservation())) return false;
			if (!Objects.equals(calculationElements, _that.getCalculationElements())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observation != null ? observation.hashCode() : 0);
			_result = 31 * _result + (calculationElements != null ? calculationElements.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResetCalculationDetails {" +
				"observation=" + this.observation + ", " +
				"calculationElements=" + this.calculationElements +
			'}';
		}
	}

	/*********************** Builder Implementation of ResetCalculationDetails  ***********************/
	class ResetCalculationDetailsBuilderImpl implements ResetCalculationDetails.ResetCalculationDetailsBuilder {
	
		protected List<Observation.ObservationBuilder> observation = new ArrayList<>();
		protected ResetCalculationElements.ResetCalculationElementsBuilder calculationElements;
		
		@Override
		@RosettaAttribute("observation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("observation")
		public List<? extends Observation.ObservationBuilder> getObservation() {
			return observation;
		}
		
		@Override
		public Observation.ObservationBuilder getOrCreateObservation(int index) {
			if (observation==null) {
				this.observation = new ArrayList<>();
			}
			return getIndex(observation, index, () -> {
						Observation.ObservationBuilder newObservation = Observation.builder();
						return newObservation;
					});
		}
		
		@Override
		@RosettaAttribute("calculationElements")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationElements")
		public ResetCalculationElements.ResetCalculationElementsBuilder getCalculationElements() {
			return calculationElements;
		}
		
		@Override
		public ResetCalculationElements.ResetCalculationElementsBuilder getOrCreateCalculationElements() {
			ResetCalculationElements.ResetCalculationElementsBuilder result;
			if (calculationElements!=null) {
				result = calculationElements;
			}
			else {
				result = calculationElements = ResetCalculationElements.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("observation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("observation")
		@Override
		public ResetCalculationDetails.ResetCalculationDetailsBuilder addObservation(Observation _observation) {
			if (_observation != null) {
				this.observation.add(_observation.toBuilder());
			}
			return this;
		}
		
		@Override
		public ResetCalculationDetails.ResetCalculationDetailsBuilder addObservation(Observation _observation, int idx) {
			getIndex(this.observation, idx, () -> _observation.toBuilder());
			return this;
		}
		
		@Override
		public ResetCalculationDetails.ResetCalculationDetailsBuilder addObservation(List<? extends Observation> observations) {
			if (observations != null) {
				for (final Observation toAdd : observations) {
					this.observation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("observation")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("observation")
		@Override
		public ResetCalculationDetails.ResetCalculationDetailsBuilder setObservation(List<? extends Observation> observations) {
			if (observations == null) {
				this.observation = new ArrayList<>();
			} else {
				this.observation = observations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("calculationElements")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationElements")
		@Override
		public ResetCalculationDetails.ResetCalculationDetailsBuilder setCalculationElements(ResetCalculationElements _calculationElements) {
			this.calculationElements = _calculationElements == null ? null : _calculationElements.toBuilder();
			return this;
		}
		
		@Override
		public ResetCalculationDetails build() {
			return new ResetCalculationDetails.ResetCalculationDetailsImpl(this);
		}
		
		@Override
		public ResetCalculationDetails.ResetCalculationDetailsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResetCalculationDetails.ResetCalculationDetailsBuilder prune() {
			observation = observation.stream().filter(b->b!=null).<Observation.ObservationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (calculationElements!=null && !calculationElements.prune().hasData()) calculationElements = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getObservation()!=null && getObservation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCalculationElements()!=null && getCalculationElements().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResetCalculationDetails.ResetCalculationDetailsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ResetCalculationDetails.ResetCalculationDetailsBuilder o = (ResetCalculationDetails.ResetCalculationDetailsBuilder) other;
			
			merger.mergeRosetta(getObservation(), o.getObservation(), this::getOrCreateObservation);
			merger.mergeRosetta(getCalculationElements(), o.getCalculationElements(), this::setCalculationElements);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ResetCalculationDetails _that = getType().cast(o);
		
			if (!ListEquals.listEquals(observation, _that.getObservation())) return false;
			if (!Objects.equals(calculationElements, _that.getCalculationElements())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observation != null ? observation.hashCode() : 0);
			_result = 31 * _result + (calculationElements != null ? calculationElements.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResetCalculationDetailsBuilder {" +
				"observation=" + this.observation + ", " +
				"calculationElements=" + this.calculationElements +
			'}';
		}
	}
}
