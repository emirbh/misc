package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.LoanBulkServicingNotificationSequenceMeta;
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
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="LoanBulkServicingNotificationSequence", builder=LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanBulkServicingNotificationSequence", model="fpml", builder=LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilderImpl.class, version="2.1.1")
public interface LoanBulkServicingNotificationSequence extends RosettaModelObject {

	LoanBulkServicingNotificationSequenceMeta metaData = new LoanBulkServicingNotificationSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A deal identifier structure.
	 *
	 */
	DealIdentifier getDealIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A deal summary structure.
	 *
	 */
	DealSummary getDealSummary();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A facility identifier structure.
	 *
	 */
	FacilityIdentifier getFacilityIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A facility summary structure.
	 *
	 */
	FacilitySummary getFacilitySummary();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends LoanBulkServicingNotificationSequenceChoice> getLoanBulkServicingNotificationSequenceChoice();

	/*********************** Build Methods  ***********************/
	LoanBulkServicingNotificationSequence build();
	
	LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder toBuilder();
	
	static LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder builder() {
		return new LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanBulkServicingNotificationSequence> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanBulkServicingNotificationSequence> getType() {
		return LoanBulkServicingNotificationSequence.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dealIdentifier"), processor, DealIdentifier.class, getDealIdentifier());
		processRosetta(path.newSubPath("dealSummary"), processor, DealSummary.class, getDealSummary());
		processRosetta(path.newSubPath("facilityIdentifier"), processor, FacilityIdentifier.class, getFacilityIdentifier());
		processRosetta(path.newSubPath("facilitySummary"), processor, FacilitySummary.class, getFacilitySummary());
		processRosetta(path.newSubPath("loanBulkServicingNotificationSequenceChoice"), processor, LoanBulkServicingNotificationSequenceChoice.class, getLoanBulkServicingNotificationSequenceChoice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanBulkServicingNotificationSequenceBuilder extends LoanBulkServicingNotificationSequence, RosettaModelObjectBuilder {
		DealIdentifier.DealIdentifierBuilder getOrCreateDealIdentifier();
		@Override
		DealIdentifier.DealIdentifierBuilder getDealIdentifier();
		DealSummary.DealSummaryBuilder getOrCreateDealSummary();
		@Override
		DealSummary.DealSummaryBuilder getDealSummary();
		FacilityIdentifier.FacilityIdentifierBuilder getOrCreateFacilityIdentifier();
		@Override
		FacilityIdentifier.FacilityIdentifierBuilder getFacilityIdentifier();
		FacilitySummary.FacilitySummaryBuilder getOrCreateFacilitySummary();
		@Override
		FacilitySummary.FacilitySummaryBuilder getFacilitySummary();
		LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilder getOrCreateLoanBulkServicingNotificationSequenceChoice(int index);
		@Override
		List<? extends LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilder> getLoanBulkServicingNotificationSequenceChoice();
		LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder setDealIdentifier(DealIdentifier dealIdentifier);
		LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder setDealSummary(DealSummary dealSummary);
		LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder setFacilityIdentifier(FacilityIdentifier facilityIdentifier);
		LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder setFacilitySummary(FacilitySummary facilitySummary);
		LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder addLoanBulkServicingNotificationSequenceChoice(LoanBulkServicingNotificationSequenceChoice loanBulkServicingNotificationSequenceChoice);
		LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder addLoanBulkServicingNotificationSequenceChoice(LoanBulkServicingNotificationSequenceChoice loanBulkServicingNotificationSequenceChoice, int idx);
		LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder addLoanBulkServicingNotificationSequenceChoice(List<? extends LoanBulkServicingNotificationSequenceChoice> loanBulkServicingNotificationSequenceChoice);
		LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder setLoanBulkServicingNotificationSequenceChoice(List<? extends LoanBulkServicingNotificationSequenceChoice> loanBulkServicingNotificationSequenceChoice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dealIdentifier"), processor, DealIdentifier.DealIdentifierBuilder.class, getDealIdentifier());
			processRosetta(path.newSubPath("dealSummary"), processor, DealSummary.DealSummaryBuilder.class, getDealSummary());
			processRosetta(path.newSubPath("facilityIdentifier"), processor, FacilityIdentifier.FacilityIdentifierBuilder.class, getFacilityIdentifier());
			processRosetta(path.newSubPath("facilitySummary"), processor, FacilitySummary.FacilitySummaryBuilder.class, getFacilitySummary());
			processRosetta(path.newSubPath("loanBulkServicingNotificationSequenceChoice"), processor, LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilder.class, getLoanBulkServicingNotificationSequenceChoice());
		}
		

		LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of LoanBulkServicingNotificationSequence  ***********************/
	class LoanBulkServicingNotificationSequenceImpl implements LoanBulkServicingNotificationSequence {
		private final DealIdentifier dealIdentifier;
		private final DealSummary dealSummary;
		private final FacilityIdentifier facilityIdentifier;
		private final FacilitySummary facilitySummary;
		private final List<? extends LoanBulkServicingNotificationSequenceChoice> loanBulkServicingNotificationSequenceChoice;
		
		protected LoanBulkServicingNotificationSequenceImpl(LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder builder) {
			this.dealIdentifier = ofNullable(builder.getDealIdentifier()).map(f->f.build()).orElse(null);
			this.dealSummary = ofNullable(builder.getDealSummary()).map(f->f.build()).orElse(null);
			this.facilityIdentifier = ofNullable(builder.getFacilityIdentifier()).map(f->f.build()).orElse(null);
			this.facilitySummary = ofNullable(builder.getFacilitySummary()).map(f->f.build()).orElse(null);
			this.loanBulkServicingNotificationSequenceChoice = ofNullable(builder.getLoanBulkServicingNotificationSequenceChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dealIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dealIdentifier")
		public DealIdentifier getDealIdentifier() {
			return dealIdentifier;
		}
		
		@Override
		@RosettaAttribute("dealSummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dealSummary")
		public DealSummary getDealSummary() {
			return dealSummary;
		}
		
		@Override
		@RosettaAttribute("facilityIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("facilityIdentifier")
		public FacilityIdentifier getFacilityIdentifier() {
			return facilityIdentifier;
		}
		
		@Override
		@RosettaAttribute("facilitySummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("facilitySummary")
		public FacilitySummary getFacilitySummary() {
			return facilitySummary;
		}
		
		@Override
		@RosettaAttribute("loanBulkServicingNotificationSequenceChoice")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanBulkServicingNotificationSequenceChoice")
		public List<? extends LoanBulkServicingNotificationSequenceChoice> getLoanBulkServicingNotificationSequenceChoice() {
			return loanBulkServicingNotificationSequenceChoice;
		}
		
		@Override
		public LoanBulkServicingNotificationSequence build() {
			return this;
		}
		
		@Override
		public LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder toBuilder() {
			LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder builder) {
			ofNullable(getDealIdentifier()).ifPresent(builder::setDealIdentifier);
			ofNullable(getDealSummary()).ifPresent(builder::setDealSummary);
			ofNullable(getFacilityIdentifier()).ifPresent(builder::setFacilityIdentifier);
			ofNullable(getFacilitySummary()).ifPresent(builder::setFacilitySummary);
			ofNullable(getLoanBulkServicingNotificationSequenceChoice()).ifPresent(builder::setLoanBulkServicingNotificationSequenceChoice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanBulkServicingNotificationSequence _that = getType().cast(o);
		
			if (!Objects.equals(dealIdentifier, _that.getDealIdentifier())) return false;
			if (!Objects.equals(dealSummary, _that.getDealSummary())) return false;
			if (!Objects.equals(facilityIdentifier, _that.getFacilityIdentifier())) return false;
			if (!Objects.equals(facilitySummary, _that.getFacilitySummary())) return false;
			if (!ListEquals.listEquals(loanBulkServicingNotificationSequenceChoice, _that.getLoanBulkServicingNotificationSequenceChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dealIdentifier != null ? dealIdentifier.hashCode() : 0);
			_result = 31 * _result + (dealSummary != null ? dealSummary.hashCode() : 0);
			_result = 31 * _result + (facilityIdentifier != null ? facilityIdentifier.hashCode() : 0);
			_result = 31 * _result + (facilitySummary != null ? facilitySummary.hashCode() : 0);
			_result = 31 * _result + (loanBulkServicingNotificationSequenceChoice != null ? loanBulkServicingNotificationSequenceChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanBulkServicingNotificationSequence {" +
				"dealIdentifier=" + this.dealIdentifier + ", " +
				"dealSummary=" + this.dealSummary + ", " +
				"facilityIdentifier=" + this.facilityIdentifier + ", " +
				"facilitySummary=" + this.facilitySummary + ", " +
				"loanBulkServicingNotificationSequenceChoice=" + this.loanBulkServicingNotificationSequenceChoice +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanBulkServicingNotificationSequence  ***********************/
	class LoanBulkServicingNotificationSequenceBuilderImpl implements LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder {
	
		protected DealIdentifier.DealIdentifierBuilder dealIdentifier;
		protected DealSummary.DealSummaryBuilder dealSummary;
		protected FacilityIdentifier.FacilityIdentifierBuilder facilityIdentifier;
		protected FacilitySummary.FacilitySummaryBuilder facilitySummary;
		protected List<LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilder> loanBulkServicingNotificationSequenceChoice = new ArrayList<>();
		
		@Override
		@RosettaAttribute("dealIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dealIdentifier")
		public DealIdentifier.DealIdentifierBuilder getDealIdentifier() {
			return dealIdentifier;
		}
		
		@Override
		public DealIdentifier.DealIdentifierBuilder getOrCreateDealIdentifier() {
			DealIdentifier.DealIdentifierBuilder result;
			if (dealIdentifier!=null) {
				result = dealIdentifier;
			}
			else {
				result = dealIdentifier = DealIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dealSummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dealSummary")
		public DealSummary.DealSummaryBuilder getDealSummary() {
			return dealSummary;
		}
		
		@Override
		public DealSummary.DealSummaryBuilder getOrCreateDealSummary() {
			DealSummary.DealSummaryBuilder result;
			if (dealSummary!=null) {
				result = dealSummary;
			}
			else {
				result = dealSummary = DealSummary.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilityIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("facilityIdentifier")
		public FacilityIdentifier.FacilityIdentifierBuilder getFacilityIdentifier() {
			return facilityIdentifier;
		}
		
		@Override
		public FacilityIdentifier.FacilityIdentifierBuilder getOrCreateFacilityIdentifier() {
			FacilityIdentifier.FacilityIdentifierBuilder result;
			if (facilityIdentifier!=null) {
				result = facilityIdentifier;
			}
			else {
				result = facilityIdentifier = FacilityIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilitySummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("facilitySummary")
		public FacilitySummary.FacilitySummaryBuilder getFacilitySummary() {
			return facilitySummary;
		}
		
		@Override
		public FacilitySummary.FacilitySummaryBuilder getOrCreateFacilitySummary() {
			FacilitySummary.FacilitySummaryBuilder result;
			if (facilitySummary!=null) {
				result = facilitySummary;
			}
			else {
				result = facilitySummary = FacilitySummary.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("loanBulkServicingNotificationSequenceChoice")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanBulkServicingNotificationSequenceChoice")
		public List<? extends LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilder> getLoanBulkServicingNotificationSequenceChoice() {
			return loanBulkServicingNotificationSequenceChoice;
		}
		
		@Override
		public LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilder getOrCreateLoanBulkServicingNotificationSequenceChoice(int index) {
			if (loanBulkServicingNotificationSequenceChoice==null) {
				this.loanBulkServicingNotificationSequenceChoice = new ArrayList<>();
			}
			return getIndex(loanBulkServicingNotificationSequenceChoice, index, () -> {
						LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilder newLoanBulkServicingNotificationSequenceChoice = LoanBulkServicingNotificationSequenceChoice.builder();
						return newLoanBulkServicingNotificationSequenceChoice;
					});
		}
		
		@RosettaAttribute("dealIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealIdentifier")
		@Override
		public LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder setDealIdentifier(DealIdentifier _dealIdentifier) {
			this.dealIdentifier = _dealIdentifier == null ? null : _dealIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dealSummary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealSummary")
		@Override
		public LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder setDealSummary(DealSummary _dealSummary) {
			this.dealSummary = _dealSummary == null ? null : _dealSummary.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("facilityIdentifier")
		@Override
		public LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder setFacilityIdentifier(FacilityIdentifier _facilityIdentifier) {
			this.facilityIdentifier = _facilityIdentifier == null ? null : _facilityIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilitySummary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("facilitySummary")
		@Override
		public LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder setFacilitySummary(FacilitySummary _facilitySummary) {
			this.facilitySummary = _facilitySummary == null ? null : _facilitySummary.toBuilder();
			return this;
		}
		
		@RosettaAttribute("loanBulkServicingNotificationSequenceChoice")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("loanBulkServicingNotificationSequenceChoice")
		@Override
		public LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder addLoanBulkServicingNotificationSequenceChoice(LoanBulkServicingNotificationSequenceChoice _loanBulkServicingNotificationSequenceChoice) {
			if (_loanBulkServicingNotificationSequenceChoice != null) {
				this.loanBulkServicingNotificationSequenceChoice.add(_loanBulkServicingNotificationSequenceChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder addLoanBulkServicingNotificationSequenceChoice(LoanBulkServicingNotificationSequenceChoice _loanBulkServicingNotificationSequenceChoice, int idx) {
			getIndex(this.loanBulkServicingNotificationSequenceChoice, idx, () -> _loanBulkServicingNotificationSequenceChoice.toBuilder());
			return this;
		}
		
		@Override
		public LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder addLoanBulkServicingNotificationSequenceChoice(List<? extends LoanBulkServicingNotificationSequenceChoice> loanBulkServicingNotificationSequenceChoices) {
			if (loanBulkServicingNotificationSequenceChoices != null) {
				for (final LoanBulkServicingNotificationSequenceChoice toAdd : loanBulkServicingNotificationSequenceChoices) {
					this.loanBulkServicingNotificationSequenceChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("loanBulkServicingNotificationSequenceChoice")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("loanBulkServicingNotificationSequenceChoice")
		@Override
		public LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder setLoanBulkServicingNotificationSequenceChoice(List<? extends LoanBulkServicingNotificationSequenceChoice> loanBulkServicingNotificationSequenceChoices) {
			if (loanBulkServicingNotificationSequenceChoices == null) {
				this.loanBulkServicingNotificationSequenceChoice = new ArrayList<>();
			} else {
				this.loanBulkServicingNotificationSequenceChoice = loanBulkServicingNotificationSequenceChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LoanBulkServicingNotificationSequence build() {
			return new LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceImpl(this);
		}
		
		@Override
		public LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder prune() {
			if (dealIdentifier!=null && !dealIdentifier.prune().hasData()) dealIdentifier = null;
			if (dealSummary!=null && !dealSummary.prune().hasData()) dealSummary = null;
			if (facilityIdentifier!=null && !facilityIdentifier.prune().hasData()) facilityIdentifier = null;
			if (facilitySummary!=null && !facilitySummary.prune().hasData()) facilitySummary = null;
			loanBulkServicingNotificationSequenceChoice = loanBulkServicingNotificationSequenceChoice.stream().filter(b->b!=null).<LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDealIdentifier()!=null && getDealIdentifier().hasData()) return true;
			if (getDealSummary()!=null && getDealSummary().hasData()) return true;
			if (getFacilityIdentifier()!=null && getFacilityIdentifier().hasData()) return true;
			if (getFacilitySummary()!=null && getFacilitySummary().hasData()) return true;
			if (getLoanBulkServicingNotificationSequenceChoice()!=null && getLoanBulkServicingNotificationSequenceChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder o = (LoanBulkServicingNotificationSequence.LoanBulkServicingNotificationSequenceBuilder) other;
			
			merger.mergeRosetta(getDealIdentifier(), o.getDealIdentifier(), this::setDealIdentifier);
			merger.mergeRosetta(getDealSummary(), o.getDealSummary(), this::setDealSummary);
			merger.mergeRosetta(getFacilityIdentifier(), o.getFacilityIdentifier(), this::setFacilityIdentifier);
			merger.mergeRosetta(getFacilitySummary(), o.getFacilitySummary(), this::setFacilitySummary);
			merger.mergeRosetta(getLoanBulkServicingNotificationSequenceChoice(), o.getLoanBulkServicingNotificationSequenceChoice(), this::getOrCreateLoanBulkServicingNotificationSequenceChoice);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanBulkServicingNotificationSequence _that = getType().cast(o);
		
			if (!Objects.equals(dealIdentifier, _that.getDealIdentifier())) return false;
			if (!Objects.equals(dealSummary, _that.getDealSummary())) return false;
			if (!Objects.equals(facilityIdentifier, _that.getFacilityIdentifier())) return false;
			if (!Objects.equals(facilitySummary, _that.getFacilitySummary())) return false;
			if (!ListEquals.listEquals(loanBulkServicingNotificationSequenceChoice, _that.getLoanBulkServicingNotificationSequenceChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dealIdentifier != null ? dealIdentifier.hashCode() : 0);
			_result = 31 * _result + (dealSummary != null ? dealSummary.hashCode() : 0);
			_result = 31 * _result + (facilityIdentifier != null ? facilityIdentifier.hashCode() : 0);
			_result = 31 * _result + (facilitySummary != null ? facilitySummary.hashCode() : 0);
			_result = 31 * _result + (loanBulkServicingNotificationSequenceChoice != null ? loanBulkServicingNotificationSequenceChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanBulkServicingNotificationSequenceBuilder {" +
				"dealIdentifier=" + this.dealIdentifier + ", " +
				"dealSummary=" + this.dealSummary + ", " +
				"facilityIdentifier=" + this.facilityIdentifier + ", " +
				"facilitySummary=" + this.facilitySummary + ", " +
				"loanBulkServicingNotificationSequenceChoice=" + this.loanBulkServicingNotificationSequenceChoice +
			'}';
		}
	}
}
