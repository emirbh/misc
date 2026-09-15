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
import fpml.consolidated.loan.meta.LoanLegalActionNotificationChoice1Meta;
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
@RosettaDataType(value="LoanLegalActionNotificationChoice1", builder=LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1BuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanLegalActionNotificationChoice1", model="fpml", builder=LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1BuilderImpl.class, version="2.1.1")
public interface LoanLegalActionNotificationChoice1 extends RosettaModelObject {

	LoanLegalActionNotificationChoice1Meta metaData = new LoanLegalActionNotificationChoice1Meta();

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
	 * Provision 
	 *
	 */
	List<? extends LoanLegalActionNotificationChoiceChoice0> getLoanLegalActionNotificationChoiceChoice0();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends LoanLegalActionNotificationChoiceChoice1> getLoanLegalActionNotificationChoiceChoice1();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends LoanLegalActionNotificationChoiceChoice2> getLoanLegalActionNotificationChoiceChoice2();

	/*********************** Build Methods  ***********************/
	LoanLegalActionNotificationChoice1 build();
	
	LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder toBuilder();
	
	static LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder builder() {
		return new LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanLegalActionNotificationChoice1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanLegalActionNotificationChoice1> getType() {
		return LoanLegalActionNotificationChoice1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dealIdentifier"), processor, DealIdentifier.class, getDealIdentifier());
		processRosetta(path.newSubPath("dealSummary"), processor, DealSummary.class, getDealSummary());
		processRosetta(path.newSubPath("loanLegalActionNotificationChoiceChoice0"), processor, LoanLegalActionNotificationChoiceChoice0.class, getLoanLegalActionNotificationChoiceChoice0());
		processRosetta(path.newSubPath("loanLegalActionNotificationChoiceChoice1"), processor, LoanLegalActionNotificationChoiceChoice1.class, getLoanLegalActionNotificationChoiceChoice1());
		processRosetta(path.newSubPath("loanLegalActionNotificationChoiceChoice2"), processor, LoanLegalActionNotificationChoiceChoice2.class, getLoanLegalActionNotificationChoiceChoice2());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanLegalActionNotificationChoice1Builder extends LoanLegalActionNotificationChoice1, RosettaModelObjectBuilder {
		DealIdentifier.DealIdentifierBuilder getOrCreateDealIdentifier();
		@Override
		DealIdentifier.DealIdentifierBuilder getDealIdentifier();
		DealSummary.DealSummaryBuilder getOrCreateDealSummary();
		@Override
		DealSummary.DealSummaryBuilder getDealSummary();
		LoanLegalActionNotificationChoiceChoice0.LoanLegalActionNotificationChoiceChoice0Builder getOrCreateLoanLegalActionNotificationChoiceChoice0(int index);
		@Override
		List<? extends LoanLegalActionNotificationChoiceChoice0.LoanLegalActionNotificationChoiceChoice0Builder> getLoanLegalActionNotificationChoiceChoice0();
		LoanLegalActionNotificationChoiceChoice1.LoanLegalActionNotificationChoiceChoice1Builder getOrCreateLoanLegalActionNotificationChoiceChoice1(int index);
		@Override
		List<? extends LoanLegalActionNotificationChoiceChoice1.LoanLegalActionNotificationChoiceChoice1Builder> getLoanLegalActionNotificationChoiceChoice1();
		LoanLegalActionNotificationChoiceChoice2.LoanLegalActionNotificationChoiceChoice2Builder getOrCreateLoanLegalActionNotificationChoiceChoice2(int index);
		@Override
		List<? extends LoanLegalActionNotificationChoiceChoice2.LoanLegalActionNotificationChoiceChoice2Builder> getLoanLegalActionNotificationChoiceChoice2();
		LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder setDealIdentifier(DealIdentifier dealIdentifier);
		LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder setDealSummary(DealSummary dealSummary);
		LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder addLoanLegalActionNotificationChoiceChoice0(LoanLegalActionNotificationChoiceChoice0 loanLegalActionNotificationChoiceChoice0);
		LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder addLoanLegalActionNotificationChoiceChoice0(LoanLegalActionNotificationChoiceChoice0 loanLegalActionNotificationChoiceChoice0, int idx);
		LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder addLoanLegalActionNotificationChoiceChoice0(List<? extends LoanLegalActionNotificationChoiceChoice0> loanLegalActionNotificationChoiceChoice0);
		LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder setLoanLegalActionNotificationChoiceChoice0(List<? extends LoanLegalActionNotificationChoiceChoice0> loanLegalActionNotificationChoiceChoice0);
		LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder addLoanLegalActionNotificationChoiceChoice1(LoanLegalActionNotificationChoiceChoice1 loanLegalActionNotificationChoiceChoice1);
		LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder addLoanLegalActionNotificationChoiceChoice1(LoanLegalActionNotificationChoiceChoice1 loanLegalActionNotificationChoiceChoice1, int idx);
		LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder addLoanLegalActionNotificationChoiceChoice1(List<? extends LoanLegalActionNotificationChoiceChoice1> loanLegalActionNotificationChoiceChoice1);
		LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder setLoanLegalActionNotificationChoiceChoice1(List<? extends LoanLegalActionNotificationChoiceChoice1> loanLegalActionNotificationChoiceChoice1);
		LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder addLoanLegalActionNotificationChoiceChoice2(LoanLegalActionNotificationChoiceChoice2 loanLegalActionNotificationChoiceChoice2);
		LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder addLoanLegalActionNotificationChoiceChoice2(LoanLegalActionNotificationChoiceChoice2 loanLegalActionNotificationChoiceChoice2, int idx);
		LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder addLoanLegalActionNotificationChoiceChoice2(List<? extends LoanLegalActionNotificationChoiceChoice2> loanLegalActionNotificationChoiceChoice2);
		LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder setLoanLegalActionNotificationChoiceChoice2(List<? extends LoanLegalActionNotificationChoiceChoice2> loanLegalActionNotificationChoiceChoice2);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dealIdentifier"), processor, DealIdentifier.DealIdentifierBuilder.class, getDealIdentifier());
			processRosetta(path.newSubPath("dealSummary"), processor, DealSummary.DealSummaryBuilder.class, getDealSummary());
			processRosetta(path.newSubPath("loanLegalActionNotificationChoiceChoice0"), processor, LoanLegalActionNotificationChoiceChoice0.LoanLegalActionNotificationChoiceChoice0Builder.class, getLoanLegalActionNotificationChoiceChoice0());
			processRosetta(path.newSubPath("loanLegalActionNotificationChoiceChoice1"), processor, LoanLegalActionNotificationChoiceChoice1.LoanLegalActionNotificationChoiceChoice1Builder.class, getLoanLegalActionNotificationChoiceChoice1());
			processRosetta(path.newSubPath("loanLegalActionNotificationChoiceChoice2"), processor, LoanLegalActionNotificationChoiceChoice2.LoanLegalActionNotificationChoiceChoice2Builder.class, getLoanLegalActionNotificationChoiceChoice2());
		}
		

		LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder prune();
	}

	/*********************** Immutable Implementation of LoanLegalActionNotificationChoice1  ***********************/
	class LoanLegalActionNotificationChoice1Impl implements LoanLegalActionNotificationChoice1 {
		private final DealIdentifier dealIdentifier;
		private final DealSummary dealSummary;
		private final List<? extends LoanLegalActionNotificationChoiceChoice0> loanLegalActionNotificationChoiceChoice0;
		private final List<? extends LoanLegalActionNotificationChoiceChoice1> loanLegalActionNotificationChoiceChoice1;
		private final List<? extends LoanLegalActionNotificationChoiceChoice2> loanLegalActionNotificationChoiceChoice2;
		
		protected LoanLegalActionNotificationChoice1Impl(LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder builder) {
			this.dealIdentifier = ofNullable(builder.getDealIdentifier()).map(f->f.build()).orElse(null);
			this.dealSummary = ofNullable(builder.getDealSummary()).map(f->f.build()).orElse(null);
			this.loanLegalActionNotificationChoiceChoice0 = ofNullable(builder.getLoanLegalActionNotificationChoiceChoice0()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.loanLegalActionNotificationChoiceChoice1 = ofNullable(builder.getLoanLegalActionNotificationChoiceChoice1()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.loanLegalActionNotificationChoiceChoice2 = ofNullable(builder.getLoanLegalActionNotificationChoiceChoice2()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
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
		@RosettaAttribute("loanLegalActionNotificationChoiceChoice0")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanLegalActionNotificationChoiceChoice0")
		public List<? extends LoanLegalActionNotificationChoiceChoice0> getLoanLegalActionNotificationChoiceChoice0() {
			return loanLegalActionNotificationChoiceChoice0;
		}
		
		@Override
		@RosettaAttribute("loanLegalActionNotificationChoiceChoice1")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanLegalActionNotificationChoiceChoice1")
		public List<? extends LoanLegalActionNotificationChoiceChoice1> getLoanLegalActionNotificationChoiceChoice1() {
			return loanLegalActionNotificationChoiceChoice1;
		}
		
		@Override
		@RosettaAttribute("loanLegalActionNotificationChoiceChoice2")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanLegalActionNotificationChoiceChoice2")
		public List<? extends LoanLegalActionNotificationChoiceChoice2> getLoanLegalActionNotificationChoiceChoice2() {
			return loanLegalActionNotificationChoiceChoice2;
		}
		
		@Override
		public LoanLegalActionNotificationChoice1 build() {
			return this;
		}
		
		@Override
		public LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder toBuilder() {
			LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder builder) {
			ofNullable(getDealIdentifier()).ifPresent(builder::setDealIdentifier);
			ofNullable(getDealSummary()).ifPresent(builder::setDealSummary);
			ofNullable(getLoanLegalActionNotificationChoiceChoice0()).ifPresent(builder::setLoanLegalActionNotificationChoiceChoice0);
			ofNullable(getLoanLegalActionNotificationChoiceChoice1()).ifPresent(builder::setLoanLegalActionNotificationChoiceChoice1);
			ofNullable(getLoanLegalActionNotificationChoiceChoice2()).ifPresent(builder::setLoanLegalActionNotificationChoiceChoice2);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanLegalActionNotificationChoice1 _that = getType().cast(o);
		
			if (!Objects.equals(dealIdentifier, _that.getDealIdentifier())) return false;
			if (!Objects.equals(dealSummary, _that.getDealSummary())) return false;
			if (!ListEquals.listEquals(loanLegalActionNotificationChoiceChoice0, _that.getLoanLegalActionNotificationChoiceChoice0())) return false;
			if (!ListEquals.listEquals(loanLegalActionNotificationChoiceChoice1, _that.getLoanLegalActionNotificationChoiceChoice1())) return false;
			if (!ListEquals.listEquals(loanLegalActionNotificationChoiceChoice2, _that.getLoanLegalActionNotificationChoiceChoice2())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dealIdentifier != null ? dealIdentifier.hashCode() : 0);
			_result = 31 * _result + (dealSummary != null ? dealSummary.hashCode() : 0);
			_result = 31 * _result + (loanLegalActionNotificationChoiceChoice0 != null ? loanLegalActionNotificationChoiceChoice0.hashCode() : 0);
			_result = 31 * _result + (loanLegalActionNotificationChoiceChoice1 != null ? loanLegalActionNotificationChoiceChoice1.hashCode() : 0);
			_result = 31 * _result + (loanLegalActionNotificationChoiceChoice2 != null ? loanLegalActionNotificationChoiceChoice2.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalActionNotificationChoice1 {" +
				"dealIdentifier=" + this.dealIdentifier + ", " +
				"dealSummary=" + this.dealSummary + ", " +
				"loanLegalActionNotificationChoiceChoice0=" + this.loanLegalActionNotificationChoiceChoice0 + ", " +
				"loanLegalActionNotificationChoiceChoice1=" + this.loanLegalActionNotificationChoiceChoice1 + ", " +
				"loanLegalActionNotificationChoiceChoice2=" + this.loanLegalActionNotificationChoiceChoice2 +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanLegalActionNotificationChoice1  ***********************/
	class LoanLegalActionNotificationChoice1BuilderImpl implements LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder {
	
		protected DealIdentifier.DealIdentifierBuilder dealIdentifier;
		protected DealSummary.DealSummaryBuilder dealSummary;
		protected List<LoanLegalActionNotificationChoiceChoice0.LoanLegalActionNotificationChoiceChoice0Builder> loanLegalActionNotificationChoiceChoice0 = new ArrayList<>();
		protected List<LoanLegalActionNotificationChoiceChoice1.LoanLegalActionNotificationChoiceChoice1Builder> loanLegalActionNotificationChoiceChoice1 = new ArrayList<>();
		protected List<LoanLegalActionNotificationChoiceChoice2.LoanLegalActionNotificationChoiceChoice2Builder> loanLegalActionNotificationChoiceChoice2 = new ArrayList<>();
		
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
		@RosettaAttribute("loanLegalActionNotificationChoiceChoice0")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanLegalActionNotificationChoiceChoice0")
		public List<? extends LoanLegalActionNotificationChoiceChoice0.LoanLegalActionNotificationChoiceChoice0Builder> getLoanLegalActionNotificationChoiceChoice0() {
			return loanLegalActionNotificationChoiceChoice0;
		}
		
		@Override
		public LoanLegalActionNotificationChoiceChoice0.LoanLegalActionNotificationChoiceChoice0Builder getOrCreateLoanLegalActionNotificationChoiceChoice0(int index) {
			if (loanLegalActionNotificationChoiceChoice0==null) {
				this.loanLegalActionNotificationChoiceChoice0 = new ArrayList<>();
			}
			return getIndex(loanLegalActionNotificationChoiceChoice0, index, () -> {
						LoanLegalActionNotificationChoiceChoice0.LoanLegalActionNotificationChoiceChoice0Builder newLoanLegalActionNotificationChoiceChoice0 = LoanLegalActionNotificationChoiceChoice0.builder();
						return newLoanLegalActionNotificationChoiceChoice0;
					});
		}
		
		@Override
		@RosettaAttribute("loanLegalActionNotificationChoiceChoice1")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanLegalActionNotificationChoiceChoice1")
		public List<? extends LoanLegalActionNotificationChoiceChoice1.LoanLegalActionNotificationChoiceChoice1Builder> getLoanLegalActionNotificationChoiceChoice1() {
			return loanLegalActionNotificationChoiceChoice1;
		}
		
		@Override
		public LoanLegalActionNotificationChoiceChoice1.LoanLegalActionNotificationChoiceChoice1Builder getOrCreateLoanLegalActionNotificationChoiceChoice1(int index) {
			if (loanLegalActionNotificationChoiceChoice1==null) {
				this.loanLegalActionNotificationChoiceChoice1 = new ArrayList<>();
			}
			return getIndex(loanLegalActionNotificationChoiceChoice1, index, () -> {
						LoanLegalActionNotificationChoiceChoice1.LoanLegalActionNotificationChoiceChoice1Builder newLoanLegalActionNotificationChoiceChoice1 = LoanLegalActionNotificationChoiceChoice1.builder();
						return newLoanLegalActionNotificationChoiceChoice1;
					});
		}
		
		@Override
		@RosettaAttribute("loanLegalActionNotificationChoiceChoice2")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanLegalActionNotificationChoiceChoice2")
		public List<? extends LoanLegalActionNotificationChoiceChoice2.LoanLegalActionNotificationChoiceChoice2Builder> getLoanLegalActionNotificationChoiceChoice2() {
			return loanLegalActionNotificationChoiceChoice2;
		}
		
		@Override
		public LoanLegalActionNotificationChoiceChoice2.LoanLegalActionNotificationChoiceChoice2Builder getOrCreateLoanLegalActionNotificationChoiceChoice2(int index) {
			if (loanLegalActionNotificationChoiceChoice2==null) {
				this.loanLegalActionNotificationChoiceChoice2 = new ArrayList<>();
			}
			return getIndex(loanLegalActionNotificationChoiceChoice2, index, () -> {
						LoanLegalActionNotificationChoiceChoice2.LoanLegalActionNotificationChoiceChoice2Builder newLoanLegalActionNotificationChoiceChoice2 = LoanLegalActionNotificationChoiceChoice2.builder();
						return newLoanLegalActionNotificationChoiceChoice2;
					});
		}
		
		@RosettaAttribute("dealIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealIdentifier")
		@Override
		public LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder setDealIdentifier(DealIdentifier _dealIdentifier) {
			this.dealIdentifier = _dealIdentifier == null ? null : _dealIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dealSummary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealSummary")
		@Override
		public LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder setDealSummary(DealSummary _dealSummary) {
			this.dealSummary = _dealSummary == null ? null : _dealSummary.toBuilder();
			return this;
		}
		
		@RosettaAttribute("loanLegalActionNotificationChoiceChoice0")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("loanLegalActionNotificationChoiceChoice0")
		@Override
		public LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder addLoanLegalActionNotificationChoiceChoice0(LoanLegalActionNotificationChoiceChoice0 _loanLegalActionNotificationChoiceChoice0) {
			if (_loanLegalActionNotificationChoiceChoice0 != null) {
				this.loanLegalActionNotificationChoiceChoice0.add(_loanLegalActionNotificationChoiceChoice0.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder addLoanLegalActionNotificationChoiceChoice0(LoanLegalActionNotificationChoiceChoice0 _loanLegalActionNotificationChoiceChoice0, int idx) {
			getIndex(this.loanLegalActionNotificationChoiceChoice0, idx, () -> _loanLegalActionNotificationChoiceChoice0.toBuilder());
			return this;
		}
		
		@Override
		public LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder addLoanLegalActionNotificationChoiceChoice0(List<? extends LoanLegalActionNotificationChoiceChoice0> loanLegalActionNotificationChoiceChoice0s) {
			if (loanLegalActionNotificationChoiceChoice0s != null) {
				for (final LoanLegalActionNotificationChoiceChoice0 toAdd : loanLegalActionNotificationChoiceChoice0s) {
					this.loanLegalActionNotificationChoiceChoice0.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("loanLegalActionNotificationChoiceChoice0")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("loanLegalActionNotificationChoiceChoice0")
		@Override
		public LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder setLoanLegalActionNotificationChoiceChoice0(List<? extends LoanLegalActionNotificationChoiceChoice0> loanLegalActionNotificationChoiceChoice0s) {
			if (loanLegalActionNotificationChoiceChoice0s == null) {
				this.loanLegalActionNotificationChoiceChoice0 = new ArrayList<>();
			} else {
				this.loanLegalActionNotificationChoiceChoice0 = loanLegalActionNotificationChoiceChoice0s.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("loanLegalActionNotificationChoiceChoice1")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("loanLegalActionNotificationChoiceChoice1")
		@Override
		public LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder addLoanLegalActionNotificationChoiceChoice1(LoanLegalActionNotificationChoiceChoice1 _loanLegalActionNotificationChoiceChoice1) {
			if (_loanLegalActionNotificationChoiceChoice1 != null) {
				this.loanLegalActionNotificationChoiceChoice1.add(_loanLegalActionNotificationChoiceChoice1.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder addLoanLegalActionNotificationChoiceChoice1(LoanLegalActionNotificationChoiceChoice1 _loanLegalActionNotificationChoiceChoice1, int idx) {
			getIndex(this.loanLegalActionNotificationChoiceChoice1, idx, () -> _loanLegalActionNotificationChoiceChoice1.toBuilder());
			return this;
		}
		
		@Override
		public LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder addLoanLegalActionNotificationChoiceChoice1(List<? extends LoanLegalActionNotificationChoiceChoice1> loanLegalActionNotificationChoiceChoice1s) {
			if (loanLegalActionNotificationChoiceChoice1s != null) {
				for (final LoanLegalActionNotificationChoiceChoice1 toAdd : loanLegalActionNotificationChoiceChoice1s) {
					this.loanLegalActionNotificationChoiceChoice1.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("loanLegalActionNotificationChoiceChoice1")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("loanLegalActionNotificationChoiceChoice1")
		@Override
		public LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder setLoanLegalActionNotificationChoiceChoice1(List<? extends LoanLegalActionNotificationChoiceChoice1> loanLegalActionNotificationChoiceChoice1s) {
			if (loanLegalActionNotificationChoiceChoice1s == null) {
				this.loanLegalActionNotificationChoiceChoice1 = new ArrayList<>();
			} else {
				this.loanLegalActionNotificationChoiceChoice1 = loanLegalActionNotificationChoiceChoice1s.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("loanLegalActionNotificationChoiceChoice2")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("loanLegalActionNotificationChoiceChoice2")
		@Override
		public LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder addLoanLegalActionNotificationChoiceChoice2(LoanLegalActionNotificationChoiceChoice2 _loanLegalActionNotificationChoiceChoice2) {
			if (_loanLegalActionNotificationChoiceChoice2 != null) {
				this.loanLegalActionNotificationChoiceChoice2.add(_loanLegalActionNotificationChoiceChoice2.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder addLoanLegalActionNotificationChoiceChoice2(LoanLegalActionNotificationChoiceChoice2 _loanLegalActionNotificationChoiceChoice2, int idx) {
			getIndex(this.loanLegalActionNotificationChoiceChoice2, idx, () -> _loanLegalActionNotificationChoiceChoice2.toBuilder());
			return this;
		}
		
		@Override
		public LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder addLoanLegalActionNotificationChoiceChoice2(List<? extends LoanLegalActionNotificationChoiceChoice2> loanLegalActionNotificationChoiceChoice2s) {
			if (loanLegalActionNotificationChoiceChoice2s != null) {
				for (final LoanLegalActionNotificationChoiceChoice2 toAdd : loanLegalActionNotificationChoiceChoice2s) {
					this.loanLegalActionNotificationChoiceChoice2.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("loanLegalActionNotificationChoiceChoice2")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("loanLegalActionNotificationChoiceChoice2")
		@Override
		public LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder setLoanLegalActionNotificationChoiceChoice2(List<? extends LoanLegalActionNotificationChoiceChoice2> loanLegalActionNotificationChoiceChoice2s) {
			if (loanLegalActionNotificationChoiceChoice2s == null) {
				this.loanLegalActionNotificationChoiceChoice2 = new ArrayList<>();
			} else {
				this.loanLegalActionNotificationChoiceChoice2 = loanLegalActionNotificationChoiceChoice2s.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LoanLegalActionNotificationChoice1 build() {
			return new LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Impl(this);
		}
		
		@Override
		public LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder prune() {
			if (dealIdentifier!=null && !dealIdentifier.prune().hasData()) dealIdentifier = null;
			if (dealSummary!=null && !dealSummary.prune().hasData()) dealSummary = null;
			loanLegalActionNotificationChoiceChoice0 = loanLegalActionNotificationChoiceChoice0.stream().filter(b->b!=null).<LoanLegalActionNotificationChoiceChoice0.LoanLegalActionNotificationChoiceChoice0Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			loanLegalActionNotificationChoiceChoice1 = loanLegalActionNotificationChoiceChoice1.stream().filter(b->b!=null).<LoanLegalActionNotificationChoiceChoice1.LoanLegalActionNotificationChoiceChoice1Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			loanLegalActionNotificationChoiceChoice2 = loanLegalActionNotificationChoiceChoice2.stream().filter(b->b!=null).<LoanLegalActionNotificationChoiceChoice2.LoanLegalActionNotificationChoiceChoice2Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDealIdentifier()!=null && getDealIdentifier().hasData()) return true;
			if (getDealSummary()!=null && getDealSummary().hasData()) return true;
			if (getLoanLegalActionNotificationChoiceChoice0()!=null && getLoanLegalActionNotificationChoiceChoice0().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLoanLegalActionNotificationChoiceChoice1()!=null && getLoanLegalActionNotificationChoiceChoice1().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLoanLegalActionNotificationChoiceChoice2()!=null && getLoanLegalActionNotificationChoiceChoice2().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder o = (LoanLegalActionNotificationChoice1.LoanLegalActionNotificationChoice1Builder) other;
			
			merger.mergeRosetta(getDealIdentifier(), o.getDealIdentifier(), this::setDealIdentifier);
			merger.mergeRosetta(getDealSummary(), o.getDealSummary(), this::setDealSummary);
			merger.mergeRosetta(getLoanLegalActionNotificationChoiceChoice0(), o.getLoanLegalActionNotificationChoiceChoice0(), this::getOrCreateLoanLegalActionNotificationChoiceChoice0);
			merger.mergeRosetta(getLoanLegalActionNotificationChoiceChoice1(), o.getLoanLegalActionNotificationChoiceChoice1(), this::getOrCreateLoanLegalActionNotificationChoiceChoice1);
			merger.mergeRosetta(getLoanLegalActionNotificationChoiceChoice2(), o.getLoanLegalActionNotificationChoiceChoice2(), this::getOrCreateLoanLegalActionNotificationChoiceChoice2);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanLegalActionNotificationChoice1 _that = getType().cast(o);
		
			if (!Objects.equals(dealIdentifier, _that.getDealIdentifier())) return false;
			if (!Objects.equals(dealSummary, _that.getDealSummary())) return false;
			if (!ListEquals.listEquals(loanLegalActionNotificationChoiceChoice0, _that.getLoanLegalActionNotificationChoiceChoice0())) return false;
			if (!ListEquals.listEquals(loanLegalActionNotificationChoiceChoice1, _that.getLoanLegalActionNotificationChoiceChoice1())) return false;
			if (!ListEquals.listEquals(loanLegalActionNotificationChoiceChoice2, _that.getLoanLegalActionNotificationChoiceChoice2())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dealIdentifier != null ? dealIdentifier.hashCode() : 0);
			_result = 31 * _result + (dealSummary != null ? dealSummary.hashCode() : 0);
			_result = 31 * _result + (loanLegalActionNotificationChoiceChoice0 != null ? loanLegalActionNotificationChoiceChoice0.hashCode() : 0);
			_result = 31 * _result + (loanLegalActionNotificationChoiceChoice1 != null ? loanLegalActionNotificationChoiceChoice1.hashCode() : 0);
			_result = 31 * _result + (loanLegalActionNotificationChoiceChoice2 != null ? loanLegalActionNotificationChoiceChoice2.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalActionNotificationChoice1Builder {" +
				"dealIdentifier=" + this.dealIdentifier + ", " +
				"dealSummary=" + this.dealSummary + ", " +
				"loanLegalActionNotificationChoiceChoice0=" + this.loanLegalActionNotificationChoiceChoice0 + ", " +
				"loanLegalActionNotificationChoiceChoice1=" + this.loanLegalActionNotificationChoiceChoice1 + ", " +
				"loanLegalActionNotificationChoiceChoice2=" + this.loanLegalActionNotificationChoiceChoice2 +
			'}';
		}
	}
}
