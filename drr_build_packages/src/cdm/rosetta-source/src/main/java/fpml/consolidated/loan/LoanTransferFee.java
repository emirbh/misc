package fpml.consolidated.loan;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.fpmlenum.LoanTransferFeePaidByEnum;
import fpml.consolidated.loan.meta.LoanTransferFeeMeta;
import fpml.consolidated.shared.NonNegativeMoney;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure that represents counterparty shares or alternatively the total amount of the assignment fee owed to the admin agent.
 *
 */
@RosettaDataType(value="LoanTransferFee", builder=LoanTransferFee.LoanTransferFeeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanTransferFee", model="fpml", builder=LoanTransferFee.LoanTransferFeeBuilderImpl.class, version="2.1.1")
public interface LoanTransferFee extends RosettaModelObject {

	LoanTransferFeeMeta metaData = new LoanTransferFeeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Rule enumeration for transfer fee split and paid by.
	 *
	 */
	LoanTransferFeePaidByEnum getPaidBy();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The amount payable to the agent for re-assigning a share in one of the underlying facilities within the deal.
	 *
	 */
	NonNegativeMoney getTotalAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Counterparty shares of the transfer fee owed to the agent.
	 *
	 */
	BuyerSellerAmounts getTransferFeeAmounts();

	/*********************** Build Methods  ***********************/
	LoanTransferFee build();
	
	LoanTransferFee.LoanTransferFeeBuilder toBuilder();
	
	static LoanTransferFee.LoanTransferFeeBuilder builder() {
		return new LoanTransferFee.LoanTransferFeeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTransferFee> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanTransferFee> getType() {
		return LoanTransferFee.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("paidBy"), LoanTransferFeePaidByEnum.class, getPaidBy(), this);
		processRosetta(path.newSubPath("totalAmount"), processor, NonNegativeMoney.class, getTotalAmount());
		processRosetta(path.newSubPath("transferFeeAmounts"), processor, BuyerSellerAmounts.class, getTransferFeeAmounts());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTransferFeeBuilder extends LoanTransferFee, RosettaModelObjectBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateTotalAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getTotalAmount();
		BuyerSellerAmounts.BuyerSellerAmountsBuilder getOrCreateTransferFeeAmounts();
		@Override
		BuyerSellerAmounts.BuyerSellerAmountsBuilder getTransferFeeAmounts();
		LoanTransferFee.LoanTransferFeeBuilder setPaidBy(LoanTransferFeePaidByEnum paidBy);
		LoanTransferFee.LoanTransferFeeBuilder setTotalAmount(NonNegativeMoney totalAmount);
		LoanTransferFee.LoanTransferFeeBuilder setTransferFeeAmounts(BuyerSellerAmounts transferFeeAmounts);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("paidBy"), LoanTransferFeePaidByEnum.class, getPaidBy(), this);
			processRosetta(path.newSubPath("totalAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getTotalAmount());
			processRosetta(path.newSubPath("transferFeeAmounts"), processor, BuyerSellerAmounts.BuyerSellerAmountsBuilder.class, getTransferFeeAmounts());
		}
		

		LoanTransferFee.LoanTransferFeeBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTransferFee  ***********************/
	class LoanTransferFeeImpl implements LoanTransferFee {
		private final LoanTransferFeePaidByEnum paidBy;
		private final NonNegativeMoney totalAmount;
		private final BuyerSellerAmounts transferFeeAmounts;
		
		protected LoanTransferFeeImpl(LoanTransferFee.LoanTransferFeeBuilder builder) {
			this.paidBy = builder.getPaidBy();
			this.totalAmount = ofNullable(builder.getTotalAmount()).map(f->f.build()).orElse(null);
			this.transferFeeAmounts = ofNullable(builder.getTransferFeeAmounts()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("paidBy")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paidBy")
		public LoanTransferFeePaidByEnum getPaidBy() {
			return paidBy;
		}
		
		@Override
		@RosettaAttribute("totalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("totalAmount")
		public NonNegativeMoney getTotalAmount() {
			return totalAmount;
		}
		
		@Override
		@RosettaAttribute("transferFeeAmounts")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transferFeeAmounts")
		public BuyerSellerAmounts getTransferFeeAmounts() {
			return transferFeeAmounts;
		}
		
		@Override
		public LoanTransferFee build() {
			return this;
		}
		
		@Override
		public LoanTransferFee.LoanTransferFeeBuilder toBuilder() {
			LoanTransferFee.LoanTransferFeeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTransferFee.LoanTransferFeeBuilder builder) {
			ofNullable(getPaidBy()).ifPresent(builder::setPaidBy);
			ofNullable(getTotalAmount()).ifPresent(builder::setTotalAmount);
			ofNullable(getTransferFeeAmounts()).ifPresent(builder::setTransferFeeAmounts);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTransferFee _that = getType().cast(o);
		
			if (!Objects.equals(paidBy, _that.getPaidBy())) return false;
			if (!Objects.equals(totalAmount, _that.getTotalAmount())) return false;
			if (!Objects.equals(transferFeeAmounts, _that.getTransferFeeAmounts())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (paidBy != null ? paidBy.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (totalAmount != null ? totalAmount.hashCode() : 0);
			_result = 31 * _result + (transferFeeAmounts != null ? transferFeeAmounts.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTransferFee {" +
				"paidBy=" + this.paidBy + ", " +
				"totalAmount=" + this.totalAmount + ", " +
				"transferFeeAmounts=" + this.transferFeeAmounts +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanTransferFee  ***********************/
	class LoanTransferFeeBuilderImpl implements LoanTransferFee.LoanTransferFeeBuilder {
	
		protected LoanTransferFeePaidByEnum paidBy;
		protected NonNegativeMoney.NonNegativeMoneyBuilder totalAmount;
		protected BuyerSellerAmounts.BuyerSellerAmountsBuilder transferFeeAmounts;
		
		@Override
		@RosettaAttribute("paidBy")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paidBy")
		public LoanTransferFeePaidByEnum getPaidBy() {
			return paidBy;
		}
		
		@Override
		@RosettaAttribute("totalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("totalAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getTotalAmount() {
			return totalAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateTotalAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (totalAmount!=null) {
				result = totalAmount;
			}
			else {
				result = totalAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("transferFeeAmounts")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transferFeeAmounts")
		public BuyerSellerAmounts.BuyerSellerAmountsBuilder getTransferFeeAmounts() {
			return transferFeeAmounts;
		}
		
		@Override
		public BuyerSellerAmounts.BuyerSellerAmountsBuilder getOrCreateTransferFeeAmounts() {
			BuyerSellerAmounts.BuyerSellerAmountsBuilder result;
			if (transferFeeAmounts!=null) {
				result = transferFeeAmounts;
			}
			else {
				result = transferFeeAmounts = BuyerSellerAmounts.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("paidBy")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paidBy")
		@Override
		public LoanTransferFee.LoanTransferFeeBuilder setPaidBy(LoanTransferFeePaidByEnum _paidBy) {
			this.paidBy = _paidBy == null ? null : _paidBy;
			return this;
		}
		
		@RosettaAttribute("totalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("totalAmount")
		@Override
		public LoanTransferFee.LoanTransferFeeBuilder setTotalAmount(NonNegativeMoney _totalAmount) {
			this.totalAmount = _totalAmount == null ? null : _totalAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("transferFeeAmounts")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("transferFeeAmounts")
		@Override
		public LoanTransferFee.LoanTransferFeeBuilder setTransferFeeAmounts(BuyerSellerAmounts _transferFeeAmounts) {
			this.transferFeeAmounts = _transferFeeAmounts == null ? null : _transferFeeAmounts.toBuilder();
			return this;
		}
		
		@Override
		public LoanTransferFee build() {
			return new LoanTransferFee.LoanTransferFeeImpl(this);
		}
		
		@Override
		public LoanTransferFee.LoanTransferFeeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTransferFee.LoanTransferFeeBuilder prune() {
			if (totalAmount!=null && !totalAmount.prune().hasData()) totalAmount = null;
			if (transferFeeAmounts!=null && !transferFeeAmounts.prune().hasData()) transferFeeAmounts = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPaidBy()!=null) return true;
			if (getTotalAmount()!=null && getTotalAmount().hasData()) return true;
			if (getTransferFeeAmounts()!=null && getTransferFeeAmounts().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTransferFee.LoanTransferFeeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanTransferFee.LoanTransferFeeBuilder o = (LoanTransferFee.LoanTransferFeeBuilder) other;
			
			merger.mergeRosetta(getTotalAmount(), o.getTotalAmount(), this::setTotalAmount);
			merger.mergeRosetta(getTransferFeeAmounts(), o.getTransferFeeAmounts(), this::setTransferFeeAmounts);
			
			merger.mergeBasic(getPaidBy(), o.getPaidBy(), this::setPaidBy);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTransferFee _that = getType().cast(o);
		
			if (!Objects.equals(paidBy, _that.getPaidBy())) return false;
			if (!Objects.equals(totalAmount, _that.getTotalAmount())) return false;
			if (!Objects.equals(transferFeeAmounts, _that.getTransferFeeAmounts())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (paidBy != null ? paidBy.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (totalAmount != null ? totalAmount.hashCode() : 0);
			_result = 31 * _result + (transferFeeAmounts != null ? transferFeeAmounts.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTransferFeeBuilder {" +
				"paidBy=" + this.paidBy + ", " +
				"totalAmount=" + this.totalAmount + ", " +
				"transferFeeAmounts=" + this.transferFeeAmounts +
			'}';
		}
	}
}
