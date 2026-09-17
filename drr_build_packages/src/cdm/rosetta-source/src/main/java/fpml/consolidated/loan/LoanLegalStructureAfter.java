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
import fpml.consolidated.loan.meta.LoanLegalStructureAfterMeta;
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
 * Provision Structure describing an asset after a legal event (e.g. Amendment, Amended and Restated Agreement, etc.).
 *
 */
@RosettaDataType(value="LoanLegalStructureAfter", builder=LoanLegalStructureAfter.LoanLegalStructureAfterBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanLegalStructureAfter", model="fpml", builder=LoanLegalStructureAfter.LoanLegalStructureAfterBuilderImpl.class, version="2.1.1")
public interface LoanLegalStructureAfter extends RosettaModelObject {

	LoanLegalStructureAfterMeta metaData = new LoanLegalStructureAfterMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A deal reference.
	 *
	 */
	DealReference getDealReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A facility reference.
	 *
	 */
	List<? extends FacilityReference> getFacilityReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends LoanLegalStructureAfterChoice> getLoanLegalStructureAfterChoice();

	/*********************** Build Methods  ***********************/
	LoanLegalStructureAfter build();
	
	LoanLegalStructureAfter.LoanLegalStructureAfterBuilder toBuilder();
	
	static LoanLegalStructureAfter.LoanLegalStructureAfterBuilder builder() {
		return new LoanLegalStructureAfter.LoanLegalStructureAfterBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanLegalStructureAfter> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanLegalStructureAfter> getType() {
		return LoanLegalStructureAfter.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dealReference"), processor, DealReference.class, getDealReference());
		processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.class, getFacilityReference());
		processRosetta(path.newSubPath("loanLegalStructureAfterChoice"), processor, LoanLegalStructureAfterChoice.class, getLoanLegalStructureAfterChoice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanLegalStructureAfterBuilder extends LoanLegalStructureAfter, RosettaModelObjectBuilder {
		DealReference.DealReferenceBuilder getOrCreateDealReference();
		@Override
		DealReference.DealReferenceBuilder getDealReference();
		FacilityReference.FacilityReferenceBuilder getOrCreateFacilityReference(int index);
		@Override
		List<? extends FacilityReference.FacilityReferenceBuilder> getFacilityReference();
		LoanLegalStructureAfterChoice.LoanLegalStructureAfterChoiceBuilder getOrCreateLoanLegalStructureAfterChoice(int index);
		@Override
		List<? extends LoanLegalStructureAfterChoice.LoanLegalStructureAfterChoiceBuilder> getLoanLegalStructureAfterChoice();
		LoanLegalStructureAfter.LoanLegalStructureAfterBuilder setDealReference(DealReference dealReference);
		LoanLegalStructureAfter.LoanLegalStructureAfterBuilder addFacilityReference(FacilityReference facilityReference);
		LoanLegalStructureAfter.LoanLegalStructureAfterBuilder addFacilityReference(FacilityReference facilityReference, int idx);
		LoanLegalStructureAfter.LoanLegalStructureAfterBuilder addFacilityReference(List<? extends FacilityReference> facilityReference);
		LoanLegalStructureAfter.LoanLegalStructureAfterBuilder setFacilityReference(List<? extends FacilityReference> facilityReference);
		LoanLegalStructureAfter.LoanLegalStructureAfterBuilder addLoanLegalStructureAfterChoice(LoanLegalStructureAfterChoice loanLegalStructureAfterChoice);
		LoanLegalStructureAfter.LoanLegalStructureAfterBuilder addLoanLegalStructureAfterChoice(LoanLegalStructureAfterChoice loanLegalStructureAfterChoice, int idx);
		LoanLegalStructureAfter.LoanLegalStructureAfterBuilder addLoanLegalStructureAfterChoice(List<? extends LoanLegalStructureAfterChoice> loanLegalStructureAfterChoice);
		LoanLegalStructureAfter.LoanLegalStructureAfterBuilder setLoanLegalStructureAfterChoice(List<? extends LoanLegalStructureAfterChoice> loanLegalStructureAfterChoice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dealReference"), processor, DealReference.DealReferenceBuilder.class, getDealReference());
			processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.FacilityReferenceBuilder.class, getFacilityReference());
			processRosetta(path.newSubPath("loanLegalStructureAfterChoice"), processor, LoanLegalStructureAfterChoice.LoanLegalStructureAfterChoiceBuilder.class, getLoanLegalStructureAfterChoice());
		}
		

		LoanLegalStructureAfter.LoanLegalStructureAfterBuilder prune();
	}

	/*********************** Immutable Implementation of LoanLegalStructureAfter  ***********************/
	class LoanLegalStructureAfterImpl implements LoanLegalStructureAfter {
		private final DealReference dealReference;
		private final List<? extends FacilityReference> facilityReference;
		private final List<? extends LoanLegalStructureAfterChoice> loanLegalStructureAfterChoice;
		
		protected LoanLegalStructureAfterImpl(LoanLegalStructureAfter.LoanLegalStructureAfterBuilder builder) {
			this.dealReference = ofNullable(builder.getDealReference()).map(f->f.build()).orElse(null);
			this.facilityReference = ofNullable(builder.getFacilityReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.loanLegalStructureAfterChoice = ofNullable(builder.getLoanLegalStructureAfterChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dealReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dealReference")
		public DealReference getDealReference() {
			return dealReference;
		}
		
		@Override
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("facilityReference")
		public List<? extends FacilityReference> getFacilityReference() {
			return facilityReference;
		}
		
		@Override
		@RosettaAttribute("loanLegalStructureAfterChoice")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanLegalStructureAfterChoice")
		public List<? extends LoanLegalStructureAfterChoice> getLoanLegalStructureAfterChoice() {
			return loanLegalStructureAfterChoice;
		}
		
		@Override
		public LoanLegalStructureAfter build() {
			return this;
		}
		
		@Override
		public LoanLegalStructureAfter.LoanLegalStructureAfterBuilder toBuilder() {
			LoanLegalStructureAfter.LoanLegalStructureAfterBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanLegalStructureAfter.LoanLegalStructureAfterBuilder builder) {
			ofNullable(getDealReference()).ifPresent(builder::setDealReference);
			ofNullable(getFacilityReference()).ifPresent(builder::setFacilityReference);
			ofNullable(getLoanLegalStructureAfterChoice()).ifPresent(builder::setLoanLegalStructureAfterChoice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanLegalStructureAfter _that = getType().cast(o);
		
			if (!Objects.equals(dealReference, _that.getDealReference())) return false;
			if (!ListEquals.listEquals(facilityReference, _that.getFacilityReference())) return false;
			if (!ListEquals.listEquals(loanLegalStructureAfterChoice, _that.getLoanLegalStructureAfterChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dealReference != null ? dealReference.hashCode() : 0);
			_result = 31 * _result + (facilityReference != null ? facilityReference.hashCode() : 0);
			_result = 31 * _result + (loanLegalStructureAfterChoice != null ? loanLegalStructureAfterChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalStructureAfter {" +
				"dealReference=" + this.dealReference + ", " +
				"facilityReference=" + this.facilityReference + ", " +
				"loanLegalStructureAfterChoice=" + this.loanLegalStructureAfterChoice +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanLegalStructureAfter  ***********************/
	class LoanLegalStructureAfterBuilderImpl implements LoanLegalStructureAfter.LoanLegalStructureAfterBuilder {
	
		protected DealReference.DealReferenceBuilder dealReference;
		protected List<FacilityReference.FacilityReferenceBuilder> facilityReference = new ArrayList<>();
		protected List<LoanLegalStructureAfterChoice.LoanLegalStructureAfterChoiceBuilder> loanLegalStructureAfterChoice = new ArrayList<>();
		
		@Override
		@RosettaAttribute("dealReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dealReference")
		public DealReference.DealReferenceBuilder getDealReference() {
			return dealReference;
		}
		
		@Override
		public DealReference.DealReferenceBuilder getOrCreateDealReference() {
			DealReference.DealReferenceBuilder result;
			if (dealReference!=null) {
				result = dealReference;
			}
			else {
				result = dealReference = DealReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("facilityReference")
		public List<? extends FacilityReference.FacilityReferenceBuilder> getFacilityReference() {
			return facilityReference;
		}
		
		@Override
		public FacilityReference.FacilityReferenceBuilder getOrCreateFacilityReference(int index) {
			if (facilityReference==null) {
				this.facilityReference = new ArrayList<>();
			}
			return getIndex(facilityReference, index, () -> {
						FacilityReference.FacilityReferenceBuilder newFacilityReference = FacilityReference.builder();
						return newFacilityReference;
					});
		}
		
		@Override
		@RosettaAttribute("loanLegalStructureAfterChoice")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanLegalStructureAfterChoice")
		public List<? extends LoanLegalStructureAfterChoice.LoanLegalStructureAfterChoiceBuilder> getLoanLegalStructureAfterChoice() {
			return loanLegalStructureAfterChoice;
		}
		
		@Override
		public LoanLegalStructureAfterChoice.LoanLegalStructureAfterChoiceBuilder getOrCreateLoanLegalStructureAfterChoice(int index) {
			if (loanLegalStructureAfterChoice==null) {
				this.loanLegalStructureAfterChoice = new ArrayList<>();
			}
			return getIndex(loanLegalStructureAfterChoice, index, () -> {
						LoanLegalStructureAfterChoice.LoanLegalStructureAfterChoiceBuilder newLoanLegalStructureAfterChoice = LoanLegalStructureAfterChoice.builder();
						return newLoanLegalStructureAfterChoice;
					});
		}
		
		@RosettaAttribute("dealReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealReference")
		@Override
		public LoanLegalStructureAfter.LoanLegalStructureAfterBuilder setDealReference(DealReference _dealReference) {
			this.dealReference = _dealReference == null ? null : _dealReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("facilityReference")
		@Override
		public LoanLegalStructureAfter.LoanLegalStructureAfterBuilder addFacilityReference(FacilityReference _facilityReference) {
			if (_facilityReference != null) {
				this.facilityReference.add(_facilityReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanLegalStructureAfter.LoanLegalStructureAfterBuilder addFacilityReference(FacilityReference _facilityReference, int idx) {
			getIndex(this.facilityReference, idx, () -> _facilityReference.toBuilder());
			return this;
		}
		
		@Override
		public LoanLegalStructureAfter.LoanLegalStructureAfterBuilder addFacilityReference(List<? extends FacilityReference> facilityReferences) {
			if (facilityReferences != null) {
				for (final FacilityReference toAdd : facilityReferences) {
					this.facilityReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("facilityReference")
		@Override
		public LoanLegalStructureAfter.LoanLegalStructureAfterBuilder setFacilityReference(List<? extends FacilityReference> facilityReferences) {
			if (facilityReferences == null) {
				this.facilityReference = new ArrayList<>();
			} else {
				this.facilityReference = facilityReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("loanLegalStructureAfterChoice")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("loanLegalStructureAfterChoice")
		@Override
		public LoanLegalStructureAfter.LoanLegalStructureAfterBuilder addLoanLegalStructureAfterChoice(LoanLegalStructureAfterChoice _loanLegalStructureAfterChoice) {
			if (_loanLegalStructureAfterChoice != null) {
				this.loanLegalStructureAfterChoice.add(_loanLegalStructureAfterChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanLegalStructureAfter.LoanLegalStructureAfterBuilder addLoanLegalStructureAfterChoice(LoanLegalStructureAfterChoice _loanLegalStructureAfterChoice, int idx) {
			getIndex(this.loanLegalStructureAfterChoice, idx, () -> _loanLegalStructureAfterChoice.toBuilder());
			return this;
		}
		
		@Override
		public LoanLegalStructureAfter.LoanLegalStructureAfterBuilder addLoanLegalStructureAfterChoice(List<? extends LoanLegalStructureAfterChoice> loanLegalStructureAfterChoices) {
			if (loanLegalStructureAfterChoices != null) {
				for (final LoanLegalStructureAfterChoice toAdd : loanLegalStructureAfterChoices) {
					this.loanLegalStructureAfterChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("loanLegalStructureAfterChoice")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("loanLegalStructureAfterChoice")
		@Override
		public LoanLegalStructureAfter.LoanLegalStructureAfterBuilder setLoanLegalStructureAfterChoice(List<? extends LoanLegalStructureAfterChoice> loanLegalStructureAfterChoices) {
			if (loanLegalStructureAfterChoices == null) {
				this.loanLegalStructureAfterChoice = new ArrayList<>();
			} else {
				this.loanLegalStructureAfterChoice = loanLegalStructureAfterChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LoanLegalStructureAfter build() {
			return new LoanLegalStructureAfter.LoanLegalStructureAfterImpl(this);
		}
		
		@Override
		public LoanLegalStructureAfter.LoanLegalStructureAfterBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalStructureAfter.LoanLegalStructureAfterBuilder prune() {
			if (dealReference!=null && !dealReference.prune().hasData()) dealReference = null;
			facilityReference = facilityReference.stream().filter(b->b!=null).<FacilityReference.FacilityReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			loanLegalStructureAfterChoice = loanLegalStructureAfterChoice.stream().filter(b->b!=null).<LoanLegalStructureAfterChoice.LoanLegalStructureAfterChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDealReference()!=null && getDealReference().hasData()) return true;
			if (getFacilityReference()!=null && getFacilityReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLoanLegalStructureAfterChoice()!=null && getLoanLegalStructureAfterChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalStructureAfter.LoanLegalStructureAfterBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanLegalStructureAfter.LoanLegalStructureAfterBuilder o = (LoanLegalStructureAfter.LoanLegalStructureAfterBuilder) other;
			
			merger.mergeRosetta(getDealReference(), o.getDealReference(), this::setDealReference);
			merger.mergeRosetta(getFacilityReference(), o.getFacilityReference(), this::getOrCreateFacilityReference);
			merger.mergeRosetta(getLoanLegalStructureAfterChoice(), o.getLoanLegalStructureAfterChoice(), this::getOrCreateLoanLegalStructureAfterChoice);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanLegalStructureAfter _that = getType().cast(o);
		
			if (!Objects.equals(dealReference, _that.getDealReference())) return false;
			if (!ListEquals.listEquals(facilityReference, _that.getFacilityReference())) return false;
			if (!ListEquals.listEquals(loanLegalStructureAfterChoice, _that.getLoanLegalStructureAfterChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dealReference != null ? dealReference.hashCode() : 0);
			_result = 31 * _result + (facilityReference != null ? facilityReference.hashCode() : 0);
			_result = 31 * _result + (loanLegalStructureAfterChoice != null ? loanLegalStructureAfterChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalStructureAfterBuilder {" +
				"dealReference=" + this.dealReference + ", " +
				"facilityReference=" + this.facilityReference + ", " +
				"loanLegalStructureAfterChoice=" + this.loanLegalStructureAfterChoice +
			'}';
		}
	}
}
