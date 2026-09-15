package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.LoanTradingLoanContractAccrualMeta;
import fpml.consolidated.shared.Money;
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
 * Provision A structure that incorporates sub-periods of an accrual calculation for a traded outstanding contract.
 *
 */
@RosettaDataType(value="LoanTradingLoanContractAccrual", builder=LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanTradingLoanContractAccrual", model="fpml", builder=LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilderImpl.class, version="2.1.1")
public interface LoanTradingLoanContractAccrual extends AbstractTradingAccrual {

	LoanTradingLoanContractAccrualMeta metaData = new LoanTradingLoanContractAccrualMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A unique id for the loan contract.
	 *
	 */
	LoanContractReference getLoanContractReference();

	/*********************** Build Methods  ***********************/
	LoanTradingLoanContractAccrual build();
	
	LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilder toBuilder();
	
	static LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilder builder() {
		return new LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradingLoanContractAccrual> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanTradingLoanContractAccrual> getType() {
		return LoanTradingLoanContractAccrual.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("amount"), processor, Money.class, getAmount());
		processRosetta(path.newSubPath("accrualPeriod"), processor, AccrualPeriod.class, getAccrualPeriod());
		processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.class, getLoanContractReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradingLoanContractAccrualBuilder extends LoanTradingLoanContractAccrual, AbstractTradingAccrual.AbstractTradingAccrualBuilder {
		LoanContractReference.LoanContractReferenceBuilder getOrCreateLoanContractReference();
		@Override
		LoanContractReference.LoanContractReferenceBuilder getLoanContractReference();
		@Override
		LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilder setAmount(Money amount);
		@Override
		LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilder addAccrualPeriod(AccrualPeriod accrualPeriod);
		@Override
		LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilder addAccrualPeriod(AccrualPeriod accrualPeriod, int idx);
		@Override
		LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilder addAccrualPeriod(List<? extends AccrualPeriod> accrualPeriod);
		@Override
		LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilder setAccrualPeriod(List<? extends AccrualPeriod> accrualPeriod);
		LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilder setLoanContractReference(LoanContractReference loanContractReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("amount"), processor, Money.MoneyBuilder.class, getAmount());
			processRosetta(path.newSubPath("accrualPeriod"), processor, AccrualPeriod.AccrualPeriodBuilder.class, getAccrualPeriod());
			processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.LoanContractReferenceBuilder.class, getLoanContractReference());
		}
		

		LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradingLoanContractAccrual  ***********************/
	class LoanTradingLoanContractAccrualImpl extends AbstractTradingAccrual.AbstractTradingAccrualImpl implements LoanTradingLoanContractAccrual {
		private final LoanContractReference loanContractReference;
		
		protected LoanTradingLoanContractAccrualImpl(LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilder builder) {
			super(builder);
			this.loanContractReference = ofNullable(builder.getLoanContractReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanContractReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("loanContractReference")
		public LoanContractReference getLoanContractReference() {
			return loanContractReference;
		}
		
		@Override
		public LoanTradingLoanContractAccrual build() {
			return this;
		}
		
		@Override
		public LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilder toBuilder() {
			LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLoanContractReference()).ifPresent(builder::setLoanContractReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradingLoanContractAccrual _that = getType().cast(o);
		
			if (!Objects.equals(loanContractReference, _that.getLoanContractReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanContractReference != null ? loanContractReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingLoanContractAccrual {" +
				"loanContractReference=" + this.loanContractReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanTradingLoanContractAccrual  ***********************/
	class LoanTradingLoanContractAccrualBuilderImpl extends AbstractTradingAccrual.AbstractTradingAccrualBuilderImpl implements LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilder {
	
		protected LoanContractReference.LoanContractReferenceBuilder loanContractReference;
		
		@Override
		@RosettaAttribute("loanContractReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("loanContractReference")
		public LoanContractReference.LoanContractReferenceBuilder getLoanContractReference() {
			return loanContractReference;
		}
		
		@Override
		public LoanContractReference.LoanContractReferenceBuilder getOrCreateLoanContractReference() {
			LoanContractReference.LoanContractReferenceBuilder result;
			if (loanContractReference!=null) {
				result = loanContractReference;
			}
			else {
				result = loanContractReference = LoanContractReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilder setAmount(Money _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accrualPeriod")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("accrualPeriod")
		@Override
		public LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilder addAccrualPeriod(AccrualPeriod _accrualPeriod) {
			if (_accrualPeriod != null) {
				this.accrualPeriod.add(_accrualPeriod.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilder addAccrualPeriod(AccrualPeriod _accrualPeriod, int idx) {
			getIndex(this.accrualPeriod, idx, () -> _accrualPeriod.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilder addAccrualPeriod(List<? extends AccrualPeriod> accrualPeriods) {
			if (accrualPeriods != null) {
				for (final AccrualPeriod toAdd : accrualPeriods) {
					this.accrualPeriod.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("accrualPeriod")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("accrualPeriod")
		@Override
		public LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilder setAccrualPeriod(List<? extends AccrualPeriod> accrualPeriods) {
			if (accrualPeriods == null) {
				this.accrualPeriod = new ArrayList<>();
			} else {
				this.accrualPeriod = accrualPeriods.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("loanContractReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("loanContractReference")
		@Override
		public LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilder setLoanContractReference(LoanContractReference _loanContractReference) {
			this.loanContractReference = _loanContractReference == null ? null : _loanContractReference.toBuilder();
			return this;
		}
		
		@Override
		public LoanTradingLoanContractAccrual build() {
			return new LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualImpl(this);
		}
		
		@Override
		public LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilder prune() {
			super.prune();
			if (loanContractReference!=null && !loanContractReference.prune().hasData()) loanContractReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLoanContractReference()!=null && getLoanContractReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilder o = (LoanTradingLoanContractAccrual.LoanTradingLoanContractAccrualBuilder) other;
			
			merger.mergeRosetta(getLoanContractReference(), o.getLoanContractReference(), this::setLoanContractReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradingLoanContractAccrual _that = getType().cast(o);
		
			if (!Objects.equals(loanContractReference, _that.getLoanContractReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanContractReference != null ? loanContractReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingLoanContractAccrualBuilder {" +
				"loanContractReference=" + this.loanContractReference +
			'}' + " " + super.toString();
		}
	}
}
