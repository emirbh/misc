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
import fpml.consolidated.loan.meta.LoanLegalStructureBeforeMeta;
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
 * Provision Structure describing an asset prior to a legal event (e.g. Amendment, Amended and Restated Agreement, etc.).
 *
 */
@RosettaDataType(value="LoanLegalStructureBefore", builder=LoanLegalStructureBefore.LoanLegalStructureBeforeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanLegalStructureBefore", model="fpml", builder=LoanLegalStructureBefore.LoanLegalStructureBeforeBuilderImpl.class, version="2.1.1")
public interface LoanLegalStructureBefore extends RosettaModelObject {

	LoanLegalStructureBeforeMeta metaData = new LoanLegalStructureBeforeMeta();

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
	 * Provision A facility reference structure
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
	List<? extends LoanLegalStructureBeforeChoice> getLoanLegalStructureBeforeChoice();

	/*********************** Build Methods  ***********************/
	LoanLegalStructureBefore build();
	
	LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder toBuilder();
	
	static LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder builder() {
		return new LoanLegalStructureBefore.LoanLegalStructureBeforeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanLegalStructureBefore> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanLegalStructureBefore> getType() {
		return LoanLegalStructureBefore.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dealReference"), processor, DealReference.class, getDealReference());
		processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.class, getFacilityReference());
		processRosetta(path.newSubPath("loanLegalStructureBeforeChoice"), processor, LoanLegalStructureBeforeChoice.class, getLoanLegalStructureBeforeChoice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanLegalStructureBeforeBuilder extends LoanLegalStructureBefore, RosettaModelObjectBuilder {
		DealReference.DealReferenceBuilder getOrCreateDealReference();
		@Override
		DealReference.DealReferenceBuilder getDealReference();
		FacilityReference.FacilityReferenceBuilder getOrCreateFacilityReference(int index);
		@Override
		List<? extends FacilityReference.FacilityReferenceBuilder> getFacilityReference();
		LoanLegalStructureBeforeChoice.LoanLegalStructureBeforeChoiceBuilder getOrCreateLoanLegalStructureBeforeChoice(int index);
		@Override
		List<? extends LoanLegalStructureBeforeChoice.LoanLegalStructureBeforeChoiceBuilder> getLoanLegalStructureBeforeChoice();
		LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder setDealReference(DealReference dealReference);
		LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder addFacilityReference(FacilityReference facilityReference);
		LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder addFacilityReference(FacilityReference facilityReference, int idx);
		LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder addFacilityReference(List<? extends FacilityReference> facilityReference);
		LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder setFacilityReference(List<? extends FacilityReference> facilityReference);
		LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder addLoanLegalStructureBeforeChoice(LoanLegalStructureBeforeChoice loanLegalStructureBeforeChoice);
		LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder addLoanLegalStructureBeforeChoice(LoanLegalStructureBeforeChoice loanLegalStructureBeforeChoice, int idx);
		LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder addLoanLegalStructureBeforeChoice(List<? extends LoanLegalStructureBeforeChoice> loanLegalStructureBeforeChoice);
		LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder setLoanLegalStructureBeforeChoice(List<? extends LoanLegalStructureBeforeChoice> loanLegalStructureBeforeChoice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dealReference"), processor, DealReference.DealReferenceBuilder.class, getDealReference());
			processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.FacilityReferenceBuilder.class, getFacilityReference());
			processRosetta(path.newSubPath("loanLegalStructureBeforeChoice"), processor, LoanLegalStructureBeforeChoice.LoanLegalStructureBeforeChoiceBuilder.class, getLoanLegalStructureBeforeChoice());
		}
		

		LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder prune();
	}

	/*********************** Immutable Implementation of LoanLegalStructureBefore  ***********************/
	class LoanLegalStructureBeforeImpl implements LoanLegalStructureBefore {
		private final DealReference dealReference;
		private final List<? extends FacilityReference> facilityReference;
		private final List<? extends LoanLegalStructureBeforeChoice> loanLegalStructureBeforeChoice;
		
		protected LoanLegalStructureBeforeImpl(LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder builder) {
			this.dealReference = ofNullable(builder.getDealReference()).map(f->f.build()).orElse(null);
			this.facilityReference = ofNullable(builder.getFacilityReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.loanLegalStructureBeforeChoice = ofNullable(builder.getLoanLegalStructureBeforeChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
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
		@RosettaAttribute("loanLegalStructureBeforeChoice")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanLegalStructureBeforeChoice")
		public List<? extends LoanLegalStructureBeforeChoice> getLoanLegalStructureBeforeChoice() {
			return loanLegalStructureBeforeChoice;
		}
		
		@Override
		public LoanLegalStructureBefore build() {
			return this;
		}
		
		@Override
		public LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder toBuilder() {
			LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder builder) {
			ofNullable(getDealReference()).ifPresent(builder::setDealReference);
			ofNullable(getFacilityReference()).ifPresent(builder::setFacilityReference);
			ofNullable(getLoanLegalStructureBeforeChoice()).ifPresent(builder::setLoanLegalStructureBeforeChoice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanLegalStructureBefore _that = getType().cast(o);
		
			if (!Objects.equals(dealReference, _that.getDealReference())) return false;
			if (!ListEquals.listEquals(facilityReference, _that.getFacilityReference())) return false;
			if (!ListEquals.listEquals(loanLegalStructureBeforeChoice, _that.getLoanLegalStructureBeforeChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dealReference != null ? dealReference.hashCode() : 0);
			_result = 31 * _result + (facilityReference != null ? facilityReference.hashCode() : 0);
			_result = 31 * _result + (loanLegalStructureBeforeChoice != null ? loanLegalStructureBeforeChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalStructureBefore {" +
				"dealReference=" + this.dealReference + ", " +
				"facilityReference=" + this.facilityReference + ", " +
				"loanLegalStructureBeforeChoice=" + this.loanLegalStructureBeforeChoice +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanLegalStructureBefore  ***********************/
	class LoanLegalStructureBeforeBuilderImpl implements LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder {
	
		protected DealReference.DealReferenceBuilder dealReference;
		protected List<FacilityReference.FacilityReferenceBuilder> facilityReference = new ArrayList<>();
		protected List<LoanLegalStructureBeforeChoice.LoanLegalStructureBeforeChoiceBuilder> loanLegalStructureBeforeChoice = new ArrayList<>();
		
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
		@RosettaAttribute("loanLegalStructureBeforeChoice")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanLegalStructureBeforeChoice")
		public List<? extends LoanLegalStructureBeforeChoice.LoanLegalStructureBeforeChoiceBuilder> getLoanLegalStructureBeforeChoice() {
			return loanLegalStructureBeforeChoice;
		}
		
		@Override
		public LoanLegalStructureBeforeChoice.LoanLegalStructureBeforeChoiceBuilder getOrCreateLoanLegalStructureBeforeChoice(int index) {
			if (loanLegalStructureBeforeChoice==null) {
				this.loanLegalStructureBeforeChoice = new ArrayList<>();
			}
			return getIndex(loanLegalStructureBeforeChoice, index, () -> {
						LoanLegalStructureBeforeChoice.LoanLegalStructureBeforeChoiceBuilder newLoanLegalStructureBeforeChoice = LoanLegalStructureBeforeChoice.builder();
						return newLoanLegalStructureBeforeChoice;
					});
		}
		
		@RosettaAttribute("dealReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealReference")
		@Override
		public LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder setDealReference(DealReference _dealReference) {
			this.dealReference = _dealReference == null ? null : _dealReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("facilityReference")
		@Override
		public LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder addFacilityReference(FacilityReference _facilityReference) {
			if (_facilityReference != null) {
				this.facilityReference.add(_facilityReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder addFacilityReference(FacilityReference _facilityReference, int idx) {
			getIndex(this.facilityReference, idx, () -> _facilityReference.toBuilder());
			return this;
		}
		
		@Override
		public LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder addFacilityReference(List<? extends FacilityReference> facilityReferences) {
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
		public LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder setFacilityReference(List<? extends FacilityReference> facilityReferences) {
			if (facilityReferences == null) {
				this.facilityReference = new ArrayList<>();
			} else {
				this.facilityReference = facilityReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("loanLegalStructureBeforeChoice")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("loanLegalStructureBeforeChoice")
		@Override
		public LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder addLoanLegalStructureBeforeChoice(LoanLegalStructureBeforeChoice _loanLegalStructureBeforeChoice) {
			if (_loanLegalStructureBeforeChoice != null) {
				this.loanLegalStructureBeforeChoice.add(_loanLegalStructureBeforeChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder addLoanLegalStructureBeforeChoice(LoanLegalStructureBeforeChoice _loanLegalStructureBeforeChoice, int idx) {
			getIndex(this.loanLegalStructureBeforeChoice, idx, () -> _loanLegalStructureBeforeChoice.toBuilder());
			return this;
		}
		
		@Override
		public LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder addLoanLegalStructureBeforeChoice(List<? extends LoanLegalStructureBeforeChoice> loanLegalStructureBeforeChoices) {
			if (loanLegalStructureBeforeChoices != null) {
				for (final LoanLegalStructureBeforeChoice toAdd : loanLegalStructureBeforeChoices) {
					this.loanLegalStructureBeforeChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("loanLegalStructureBeforeChoice")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("loanLegalStructureBeforeChoice")
		@Override
		public LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder setLoanLegalStructureBeforeChoice(List<? extends LoanLegalStructureBeforeChoice> loanLegalStructureBeforeChoices) {
			if (loanLegalStructureBeforeChoices == null) {
				this.loanLegalStructureBeforeChoice = new ArrayList<>();
			} else {
				this.loanLegalStructureBeforeChoice = loanLegalStructureBeforeChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LoanLegalStructureBefore build() {
			return new LoanLegalStructureBefore.LoanLegalStructureBeforeImpl(this);
		}
		
		@Override
		public LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder prune() {
			if (dealReference!=null && !dealReference.prune().hasData()) dealReference = null;
			facilityReference = facilityReference.stream().filter(b->b!=null).<FacilityReference.FacilityReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			loanLegalStructureBeforeChoice = loanLegalStructureBeforeChoice.stream().filter(b->b!=null).<LoanLegalStructureBeforeChoice.LoanLegalStructureBeforeChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDealReference()!=null && getDealReference().hasData()) return true;
			if (getFacilityReference()!=null && getFacilityReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLoanLegalStructureBeforeChoice()!=null && getLoanLegalStructureBeforeChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder o = (LoanLegalStructureBefore.LoanLegalStructureBeforeBuilder) other;
			
			merger.mergeRosetta(getDealReference(), o.getDealReference(), this::setDealReference);
			merger.mergeRosetta(getFacilityReference(), o.getFacilityReference(), this::getOrCreateFacilityReference);
			merger.mergeRosetta(getLoanLegalStructureBeforeChoice(), o.getLoanLegalStructureBeforeChoice(), this::getOrCreateLoanLegalStructureBeforeChoice);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanLegalStructureBefore _that = getType().cast(o);
		
			if (!Objects.equals(dealReference, _that.getDealReference())) return false;
			if (!ListEquals.listEquals(facilityReference, _that.getFacilityReference())) return false;
			if (!ListEquals.listEquals(loanLegalStructureBeforeChoice, _that.getLoanLegalStructureBeforeChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dealReference != null ? dealReference.hashCode() : 0);
			_result = 31 * _result + (facilityReference != null ? facilityReference.hashCode() : 0);
			_result = 31 * _result + (loanLegalStructureBeforeChoice != null ? loanLegalStructureBeforeChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalStructureBeforeBuilder {" +
				"dealReference=" + this.dealReference + ", " +
				"facilityReference=" + this.facilityReference + ", " +
				"loanLegalStructureBeforeChoice=" + this.loanLegalStructureBeforeChoice +
			'}';
		}
	}
}
