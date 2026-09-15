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
import fpml.consolidated.business.events.meta.ResetEventMeta;
import fpml.consolidated.doc.PartyTradeIdentifiers;
import fpml.consolidated.shared.IdentifiedRate;
import fpml.consolidated.shared.LegIdentifier;
import fpml.consolidated.shared.RequiredIdentifierDate;
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
@RosettaDataType(value="ResetEvent", builder=ResetEvent.ResetEventBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ResetEvent", model="fpml", builder=ResetEvent.ResetEventBuilderImpl.class, version="2.1.1")
public interface ResetEvent extends AbstractEvent {

	ResetEventMeta metaData = new ResetEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A container since an individual trade can be referenced by two or more different partyTradeIdentifier elements - each allocated by a different party.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A container since an individual trade can be referenced by two or more different partyTradeIdentifier elements - each allocated by a different party.
	 *
	 */
	PartyTradeIdentifiers getTradeReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Version aware identification of this leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Version aware identification of this leg.
	 *
	 */
	List<? extends LegIdentifier> getLegIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Date of reset.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Date of reset.
	 *
	 */
	RequiredIdentifierDate getDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Value of reset.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Value of reset.
	 *
	 */
	IdentifiedRate getResetValue();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The set of calculations that comprise this reset value.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The set of calculations that comprise this reset value.
	 *
	 */
	ResetCalculationDetails getCalculationDetails();

	/*********************** Build Methods  ***********************/
	ResetEvent build();
	
	ResetEvent.ResetEventBuilder toBuilder();
	
	static ResetEvent.ResetEventBuilder builder() {
		return new ResetEvent.ResetEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ResetEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ResetEvent> getType() {
		return ResetEvent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("tradeReference"), processor, PartyTradeIdentifiers.class, getTradeReference());
		processRosetta(path.newSubPath("legIdentifier"), processor, LegIdentifier.class, getLegIdentifier());
		processRosetta(path.newSubPath("date"), processor, RequiredIdentifierDate.class, getDate());
		processRosetta(path.newSubPath("resetValue"), processor, IdentifiedRate.class, getResetValue());
		processRosetta(path.newSubPath("calculationDetails"), processor, ResetCalculationDetails.class, getCalculationDetails());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ResetEventBuilder extends ResetEvent, AbstractEvent.AbstractEventBuilder {
		PartyTradeIdentifiers.PartyTradeIdentifiersBuilder getOrCreateTradeReference();
		@Override
		PartyTradeIdentifiers.PartyTradeIdentifiersBuilder getTradeReference();
		LegIdentifier.LegIdentifierBuilder getOrCreateLegIdentifier(int index);
		@Override
		List<? extends LegIdentifier.LegIdentifierBuilder> getLegIdentifier();
		RequiredIdentifierDate.RequiredIdentifierDateBuilder getOrCreateDate();
		@Override
		RequiredIdentifierDate.RequiredIdentifierDateBuilder getDate();
		IdentifiedRate.IdentifiedRateBuilder getOrCreateResetValue();
		@Override
		IdentifiedRate.IdentifiedRateBuilder getResetValue();
		ResetCalculationDetails.ResetCalculationDetailsBuilder getOrCreateCalculationDetails();
		@Override
		ResetCalculationDetails.ResetCalculationDetailsBuilder getCalculationDetails();
		@Override
		ResetEvent.ResetEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		ResetEvent.ResetEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		ResetEvent.ResetEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		ResetEvent.ResetEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		ResetEvent.ResetEventBuilder setTradeReference(PartyTradeIdentifiers tradeReference);
		ResetEvent.ResetEventBuilder addLegIdentifier(LegIdentifier legIdentifier);
		ResetEvent.ResetEventBuilder addLegIdentifier(LegIdentifier legIdentifier, int idx);
		ResetEvent.ResetEventBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifier);
		ResetEvent.ResetEventBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifier);
		ResetEvent.ResetEventBuilder setDate(RequiredIdentifierDate date);
		ResetEvent.ResetEventBuilder setResetValue(IdentifiedRate resetValue);
		ResetEvent.ResetEventBuilder setCalculationDetails(ResetCalculationDetails calculationDetails);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("tradeReference"), processor, PartyTradeIdentifiers.PartyTradeIdentifiersBuilder.class, getTradeReference());
			processRosetta(path.newSubPath("legIdentifier"), processor, LegIdentifier.LegIdentifierBuilder.class, getLegIdentifier());
			processRosetta(path.newSubPath("date"), processor, RequiredIdentifierDate.RequiredIdentifierDateBuilder.class, getDate());
			processRosetta(path.newSubPath("resetValue"), processor, IdentifiedRate.IdentifiedRateBuilder.class, getResetValue());
			processRosetta(path.newSubPath("calculationDetails"), processor, ResetCalculationDetails.ResetCalculationDetailsBuilder.class, getCalculationDetails());
		}
		

		ResetEvent.ResetEventBuilder prune();
	}

	/*********************** Immutable Implementation of ResetEvent  ***********************/
	class ResetEventImpl extends AbstractEvent.AbstractEventImpl implements ResetEvent {
		private final PartyTradeIdentifiers tradeReference;
		private final List<? extends LegIdentifier> legIdentifier;
		private final RequiredIdentifierDate date;
		private final IdentifiedRate resetValue;
		private final ResetCalculationDetails calculationDetails;
		
		protected ResetEventImpl(ResetEvent.ResetEventBuilder builder) {
			super(builder);
			this.tradeReference = ofNullable(builder.getTradeReference()).map(f->f.build()).orElse(null);
			this.legIdentifier = ofNullable(builder.getLegIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.date = ofNullable(builder.getDate()).map(f->f.build()).orElse(null);
			this.resetValue = ofNullable(builder.getResetValue()).map(f->f.build()).orElse(null);
			this.calculationDetails = ofNullable(builder.getCalculationDetails()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradeReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeReference")
		public PartyTradeIdentifiers getTradeReference() {
			return tradeReference;
		}
		
		@Override
		@RosettaAttribute("legIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("legIdentifier")
		public List<? extends LegIdentifier> getLegIdentifier() {
			return legIdentifier;
		}
		
		@Override
		@RosettaAttribute("date")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("date")
		public RequiredIdentifierDate getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("resetValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("resetValue")
		public IdentifiedRate getResetValue() {
			return resetValue;
		}
		
		@Override
		@RosettaAttribute("calculationDetails")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationDetails")
		public ResetCalculationDetails getCalculationDetails() {
			return calculationDetails;
		}
		
		@Override
		public ResetEvent build() {
			return this;
		}
		
		@Override
		public ResetEvent.ResetEventBuilder toBuilder() {
			ResetEvent.ResetEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ResetEvent.ResetEventBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTradeReference()).ifPresent(builder::setTradeReference);
			ofNullable(getLegIdentifier()).ifPresent(builder::setLegIdentifier);
			ofNullable(getDate()).ifPresent(builder::setDate);
			ofNullable(getResetValue()).ifPresent(builder::setResetValue);
			ofNullable(getCalculationDetails()).ifPresent(builder::setCalculationDetails);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ResetEvent _that = getType().cast(o);
		
			if (!Objects.equals(tradeReference, _that.getTradeReference())) return false;
			if (!ListEquals.listEquals(legIdentifier, _that.getLegIdentifier())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(resetValue, _that.getResetValue())) return false;
			if (!Objects.equals(calculationDetails, _that.getCalculationDetails())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradeReference != null ? tradeReference.hashCode() : 0);
			_result = 31 * _result + (legIdentifier != null ? legIdentifier.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (resetValue != null ? resetValue.hashCode() : 0);
			_result = 31 * _result + (calculationDetails != null ? calculationDetails.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResetEvent {" +
				"tradeReference=" + this.tradeReference + ", " +
				"legIdentifier=" + this.legIdentifier + ", " +
				"date=" + this.date + ", " +
				"resetValue=" + this.resetValue + ", " +
				"calculationDetails=" + this.calculationDetails +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ResetEvent  ***********************/
	class ResetEventBuilderImpl extends AbstractEvent.AbstractEventBuilderImpl implements ResetEvent.ResetEventBuilder {
	
		protected PartyTradeIdentifiers.PartyTradeIdentifiersBuilder tradeReference;
		protected List<LegIdentifier.LegIdentifierBuilder> legIdentifier = new ArrayList<>();
		protected RequiredIdentifierDate.RequiredIdentifierDateBuilder date;
		protected IdentifiedRate.IdentifiedRateBuilder resetValue;
		protected ResetCalculationDetails.ResetCalculationDetailsBuilder calculationDetails;
		
		@Override
		@RosettaAttribute("tradeReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeReference")
		public PartyTradeIdentifiers.PartyTradeIdentifiersBuilder getTradeReference() {
			return tradeReference;
		}
		
		@Override
		public PartyTradeIdentifiers.PartyTradeIdentifiersBuilder getOrCreateTradeReference() {
			PartyTradeIdentifiers.PartyTradeIdentifiersBuilder result;
			if (tradeReference!=null) {
				result = tradeReference;
			}
			else {
				result = tradeReference = PartyTradeIdentifiers.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("legIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("legIdentifier")
		public List<? extends LegIdentifier.LegIdentifierBuilder> getLegIdentifier() {
			return legIdentifier;
		}
		
		@Override
		public LegIdentifier.LegIdentifierBuilder getOrCreateLegIdentifier(int index) {
			if (legIdentifier==null) {
				this.legIdentifier = new ArrayList<>();
			}
			return getIndex(legIdentifier, index, () -> {
						LegIdentifier.LegIdentifierBuilder newLegIdentifier = LegIdentifier.builder();
						return newLegIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("date")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("date")
		public RequiredIdentifierDate.RequiredIdentifierDateBuilder getDate() {
			return date;
		}
		
		@Override
		public RequiredIdentifierDate.RequiredIdentifierDateBuilder getOrCreateDate() {
			RequiredIdentifierDate.RequiredIdentifierDateBuilder result;
			if (date!=null) {
				result = date;
			}
			else {
				result = date = RequiredIdentifierDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("resetValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("resetValue")
		public IdentifiedRate.IdentifiedRateBuilder getResetValue() {
			return resetValue;
		}
		
		@Override
		public IdentifiedRate.IdentifiedRateBuilder getOrCreateResetValue() {
			IdentifiedRate.IdentifiedRateBuilder result;
			if (resetValue!=null) {
				result = resetValue;
			}
			else {
				result = resetValue = IdentifiedRate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationDetails")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationDetails")
		public ResetCalculationDetails.ResetCalculationDetailsBuilder getCalculationDetails() {
			return calculationDetails;
		}
		
		@Override
		public ResetCalculationDetails.ResetCalculationDetailsBuilder getOrCreateCalculationDetails() {
			ResetCalculationDetails.ResetCalculationDetailsBuilder result;
			if (calculationDetails!=null) {
				result = calculationDetails;
			}
			else {
				result = calculationDetails = ResetCalculationDetails.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public ResetEvent.ResetEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public ResetEvent.ResetEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public ResetEvent.ResetEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (final BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public ResetEvent.ResetEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers == null) {
				this.eventIdentifier = new ArrayList<>();
			} else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("tradeReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeReference")
		@Override
		public ResetEvent.ResetEventBuilder setTradeReference(PartyTradeIdentifiers _tradeReference) {
			this.tradeReference = _tradeReference == null ? null : _tradeReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("legIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("legIdentifier")
		@Override
		public ResetEvent.ResetEventBuilder addLegIdentifier(LegIdentifier _legIdentifier) {
			if (_legIdentifier != null) {
				this.legIdentifier.add(_legIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public ResetEvent.ResetEventBuilder addLegIdentifier(LegIdentifier _legIdentifier, int idx) {
			getIndex(this.legIdentifier, idx, () -> _legIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public ResetEvent.ResetEventBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
			if (legIdentifiers != null) {
				for (final LegIdentifier toAdd : legIdentifiers) {
					this.legIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("legIdentifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("legIdentifier")
		@Override
		public ResetEvent.ResetEventBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
			if (legIdentifiers == null) {
				this.legIdentifier = new ArrayList<>();
			} else {
				this.legIdentifier = legIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("date")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("date")
		@Override
		public ResetEvent.ResetEventBuilder setDate(RequiredIdentifierDate _date) {
			this.date = _date == null ? null : _date.toBuilder();
			return this;
		}
		
		@RosettaAttribute("resetValue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("resetValue")
		@Override
		public ResetEvent.ResetEventBuilder setResetValue(IdentifiedRate _resetValue) {
			this.resetValue = _resetValue == null ? null : _resetValue.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationDetails")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationDetails")
		@Override
		public ResetEvent.ResetEventBuilder setCalculationDetails(ResetCalculationDetails _calculationDetails) {
			this.calculationDetails = _calculationDetails == null ? null : _calculationDetails.toBuilder();
			return this;
		}
		
		@Override
		public ResetEvent build() {
			return new ResetEvent.ResetEventImpl(this);
		}
		
		@Override
		public ResetEvent.ResetEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResetEvent.ResetEventBuilder prune() {
			super.prune();
			if (tradeReference!=null && !tradeReference.prune().hasData()) tradeReference = null;
			legIdentifier = legIdentifier.stream().filter(b->b!=null).<LegIdentifier.LegIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (date!=null && !date.prune().hasData()) date = null;
			if (resetValue!=null && !resetValue.prune().hasData()) resetValue = null;
			if (calculationDetails!=null && !calculationDetails.prune().hasData()) calculationDetails = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTradeReference()!=null && getTradeReference().hasData()) return true;
			if (getLegIdentifier()!=null && getLegIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDate()!=null && getDate().hasData()) return true;
			if (getResetValue()!=null && getResetValue().hasData()) return true;
			if (getCalculationDetails()!=null && getCalculationDetails().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResetEvent.ResetEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ResetEvent.ResetEventBuilder o = (ResetEvent.ResetEventBuilder) other;
			
			merger.mergeRosetta(getTradeReference(), o.getTradeReference(), this::setTradeReference);
			merger.mergeRosetta(getLegIdentifier(), o.getLegIdentifier(), this::getOrCreateLegIdentifier);
			merger.mergeRosetta(getDate(), o.getDate(), this::setDate);
			merger.mergeRosetta(getResetValue(), o.getResetValue(), this::setResetValue);
			merger.mergeRosetta(getCalculationDetails(), o.getCalculationDetails(), this::setCalculationDetails);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ResetEvent _that = getType().cast(o);
		
			if (!Objects.equals(tradeReference, _that.getTradeReference())) return false;
			if (!ListEquals.listEquals(legIdentifier, _that.getLegIdentifier())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(resetValue, _that.getResetValue())) return false;
			if (!Objects.equals(calculationDetails, _that.getCalculationDetails())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradeReference != null ? tradeReference.hashCode() : 0);
			_result = 31 * _result + (legIdentifier != null ? legIdentifier.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (resetValue != null ? resetValue.hashCode() : 0);
			_result = 31 * _result + (calculationDetails != null ? calculationDetails.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResetEventBuilder {" +
				"tradeReference=" + this.tradeReference + ", " +
				"legIdentifier=" + this.legIdentifier + ", " +
				"date=" + this.date + ", " +
				"resetValue=" + this.resetValue + ", " +
				"calculationDetails=" + this.calculationDetails +
			'}' + " " + super.toString();
		}
	}
}
