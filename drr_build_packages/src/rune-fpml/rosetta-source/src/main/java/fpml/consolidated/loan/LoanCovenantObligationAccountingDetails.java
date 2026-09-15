package fpml.consolidated.loan;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import fpml.consolidated.fpmlenum.AccountingStandardEnum;
import fpml.consolidated.fpmlenum.InventoryAccountingMethodEnum;
import fpml.consolidated.loan.meta.LoanCovenantObligationAccountingDetailsMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure to describe the accounting details of a covenant obligation.
 *
 */
@RosettaDataType(value="LoanCovenantObligationAccountingDetails", builder=LoanCovenantObligationAccountingDetails.LoanCovenantObligationAccountingDetailsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanCovenantObligationAccountingDetails", model="fpml", builder=LoanCovenantObligationAccountingDetails.LoanCovenantObligationAccountingDetailsBuilderImpl.class, version="2.1.1")
public interface LoanCovenantObligationAccountingDetails extends RosettaModelObject {

	LoanCovenantObligationAccountingDetailsMeta metaData = new LoanCovenantObligationAccountingDetailsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type of accounting standard applicable to the loan covenant obligation, based on an enumeration.
	 *
	 */
	AccountingStandardEnum getAccountingStandard();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type of inventory accounting methodology applicatble to the loan covenant obligation, based on an enumeration.
	 *
	 */
	InventoryAccountingMethodEnum getInventoryMethod();

	/*********************** Build Methods  ***********************/
	LoanCovenantObligationAccountingDetails build();
	
	LoanCovenantObligationAccountingDetails.LoanCovenantObligationAccountingDetailsBuilder toBuilder();
	
	static LoanCovenantObligationAccountingDetails.LoanCovenantObligationAccountingDetailsBuilder builder() {
		return new LoanCovenantObligationAccountingDetails.LoanCovenantObligationAccountingDetailsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanCovenantObligationAccountingDetails> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanCovenantObligationAccountingDetails> getType() {
		return LoanCovenantObligationAccountingDetails.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("accountingStandard"), AccountingStandardEnum.class, getAccountingStandard(), this);
		processor.processBasic(path.newSubPath("inventoryMethod"), InventoryAccountingMethodEnum.class, getInventoryMethod(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanCovenantObligationAccountingDetailsBuilder extends LoanCovenantObligationAccountingDetails, RosettaModelObjectBuilder {
		LoanCovenantObligationAccountingDetails.LoanCovenantObligationAccountingDetailsBuilder setAccountingStandard(AccountingStandardEnum accountingStandard);
		LoanCovenantObligationAccountingDetails.LoanCovenantObligationAccountingDetailsBuilder setInventoryMethod(InventoryAccountingMethodEnum inventoryMethod);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("accountingStandard"), AccountingStandardEnum.class, getAccountingStandard(), this);
			processor.processBasic(path.newSubPath("inventoryMethod"), InventoryAccountingMethodEnum.class, getInventoryMethod(), this);
		}
		

		LoanCovenantObligationAccountingDetails.LoanCovenantObligationAccountingDetailsBuilder prune();
	}

	/*********************** Immutable Implementation of LoanCovenantObligationAccountingDetails  ***********************/
	class LoanCovenantObligationAccountingDetailsImpl implements LoanCovenantObligationAccountingDetails {
		private final AccountingStandardEnum accountingStandard;
		private final InventoryAccountingMethodEnum inventoryMethod;
		
		protected LoanCovenantObligationAccountingDetailsImpl(LoanCovenantObligationAccountingDetails.LoanCovenantObligationAccountingDetailsBuilder builder) {
			this.accountingStandard = builder.getAccountingStandard();
			this.inventoryMethod = builder.getInventoryMethod();
		}
		
		@Override
		@RosettaAttribute("accountingStandard")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("accountingStandard")
		public AccountingStandardEnum getAccountingStandard() {
			return accountingStandard;
		}
		
		@Override
		@RosettaAttribute("inventoryMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("inventoryMethod")
		public InventoryAccountingMethodEnum getInventoryMethod() {
			return inventoryMethod;
		}
		
		@Override
		public LoanCovenantObligationAccountingDetails build() {
			return this;
		}
		
		@Override
		public LoanCovenantObligationAccountingDetails.LoanCovenantObligationAccountingDetailsBuilder toBuilder() {
			LoanCovenantObligationAccountingDetails.LoanCovenantObligationAccountingDetailsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanCovenantObligationAccountingDetails.LoanCovenantObligationAccountingDetailsBuilder builder) {
			ofNullable(getAccountingStandard()).ifPresent(builder::setAccountingStandard);
			ofNullable(getInventoryMethod()).ifPresent(builder::setInventoryMethod);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanCovenantObligationAccountingDetails _that = getType().cast(o);
		
			if (!Objects.equals(accountingStandard, _that.getAccountingStandard())) return false;
			if (!Objects.equals(inventoryMethod, _that.getInventoryMethod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (accountingStandard != null ? accountingStandard.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (inventoryMethod != null ? inventoryMethod.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationAccountingDetails {" +
				"accountingStandard=" + this.accountingStandard + ", " +
				"inventoryMethod=" + this.inventoryMethod +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanCovenantObligationAccountingDetails  ***********************/
	class LoanCovenantObligationAccountingDetailsBuilderImpl implements LoanCovenantObligationAccountingDetails.LoanCovenantObligationAccountingDetailsBuilder {
	
		protected AccountingStandardEnum accountingStandard;
		protected InventoryAccountingMethodEnum inventoryMethod;
		
		@Override
		@RosettaAttribute("accountingStandard")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("accountingStandard")
		public AccountingStandardEnum getAccountingStandard() {
			return accountingStandard;
		}
		
		@Override
		@RosettaAttribute("inventoryMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("inventoryMethod")
		public InventoryAccountingMethodEnum getInventoryMethod() {
			return inventoryMethod;
		}
		
		@RosettaAttribute("accountingStandard")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("accountingStandard")
		@Override
		public LoanCovenantObligationAccountingDetails.LoanCovenantObligationAccountingDetailsBuilder setAccountingStandard(AccountingStandardEnum _accountingStandard) {
			this.accountingStandard = _accountingStandard == null ? null : _accountingStandard;
			return this;
		}
		
		@RosettaAttribute("inventoryMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("inventoryMethod")
		@Override
		public LoanCovenantObligationAccountingDetails.LoanCovenantObligationAccountingDetailsBuilder setInventoryMethod(InventoryAccountingMethodEnum _inventoryMethod) {
			this.inventoryMethod = _inventoryMethod == null ? null : _inventoryMethod;
			return this;
		}
		
		@Override
		public LoanCovenantObligationAccountingDetails build() {
			return new LoanCovenantObligationAccountingDetails.LoanCovenantObligationAccountingDetailsImpl(this);
		}
		
		@Override
		public LoanCovenantObligationAccountingDetails.LoanCovenantObligationAccountingDetailsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationAccountingDetails.LoanCovenantObligationAccountingDetailsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAccountingStandard()!=null) return true;
			if (getInventoryMethod()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationAccountingDetails.LoanCovenantObligationAccountingDetailsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanCovenantObligationAccountingDetails.LoanCovenantObligationAccountingDetailsBuilder o = (LoanCovenantObligationAccountingDetails.LoanCovenantObligationAccountingDetailsBuilder) other;
			
			
			merger.mergeBasic(getAccountingStandard(), o.getAccountingStandard(), this::setAccountingStandard);
			merger.mergeBasic(getInventoryMethod(), o.getInventoryMethod(), this::setInventoryMethod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanCovenantObligationAccountingDetails _that = getType().cast(o);
		
			if (!Objects.equals(accountingStandard, _that.getAccountingStandard())) return false;
			if (!Objects.equals(inventoryMethod, _that.getInventoryMethod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (accountingStandard != null ? accountingStandard.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (inventoryMethod != null ? inventoryMethod.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationAccountingDetailsBuilder {" +
				"accountingStandard=" + this.accountingStandard + ", " +
				"inventoryMethod=" + this.inventoryMethod +
			'}';
		}
	}
}
