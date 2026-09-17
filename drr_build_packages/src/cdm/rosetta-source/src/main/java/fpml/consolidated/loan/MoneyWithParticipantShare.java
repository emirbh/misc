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
import fpml.consolidated.loan.meta.MoneyWithParticipantShareMeta;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Money;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision An extension of the money type with the ability to specify a lender share amount in addition to the global amount (represented by 'amount').
 *
 */
@RosettaDataType(value="MoneyWithParticipantShare", builder=MoneyWithParticipantShare.MoneyWithParticipantShareBuilderImpl.class, version="2.1.1")
@RuneDataType(value="MoneyWithParticipantShare", model="fpml", builder=MoneyWithParticipantShare.MoneyWithParticipantShareBuilderImpl.class, version="2.1.1")
public interface MoneyWithParticipantShare extends Money {

	MoneyWithParticipantShareMeta metaData = new MoneyWithParticipantShareMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The lender share amount.
	 *
	 */
	BigDecimal getShareAmount();

	/*********************** Build Methods  ***********************/
	MoneyWithParticipantShare build();
	
	MoneyWithParticipantShare.MoneyWithParticipantShareBuilder toBuilder();
	
	static MoneyWithParticipantShare.MoneyWithParticipantShareBuilder builder() {
		return new MoneyWithParticipantShare.MoneyWithParticipantShareBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MoneyWithParticipantShare> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MoneyWithParticipantShare> getType() {
		return MoneyWithParticipantShare.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
		processor.processBasic(path.newSubPath("shareAmount"), BigDecimal.class, getShareAmount(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MoneyWithParticipantShareBuilder extends MoneyWithParticipantShare, Money.MoneyBuilder {
		@Override
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder setId(String id);
		@Override
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder setCurrency(Currency currency);
		@Override
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder setAmount(BigDecimal amount);
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder setShareAmount(BigDecimal shareAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
			processor.processBasic(path.newSubPath("shareAmount"), BigDecimal.class, getShareAmount(), this);
		}
		

		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder prune();
	}

	/*********************** Immutable Implementation of MoneyWithParticipantShare  ***********************/
	class MoneyWithParticipantShareImpl extends Money.MoneyImpl implements MoneyWithParticipantShare {
		private final BigDecimal shareAmount;
		
		protected MoneyWithParticipantShareImpl(MoneyWithParticipantShare.MoneyWithParticipantShareBuilder builder) {
			super(builder);
			this.shareAmount = builder.getShareAmount();
		}
		
		@Override
		@RosettaAttribute("shareAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("shareAmount")
		public BigDecimal getShareAmount() {
			return shareAmount;
		}
		
		@Override
		public MoneyWithParticipantShare build() {
			return this;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder toBuilder() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MoneyWithParticipantShare.MoneyWithParticipantShareBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getShareAmount()).ifPresent(builder::setShareAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MoneyWithParticipantShare _that = getType().cast(o);
		
			if (!Objects.equals(shareAmount, _that.getShareAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (shareAmount != null ? shareAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MoneyWithParticipantShare {" +
				"shareAmount=" + this.shareAmount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of MoneyWithParticipantShare  ***********************/
	class MoneyWithParticipantShareBuilderImpl extends Money.MoneyBuilderImpl implements MoneyWithParticipantShare.MoneyWithParticipantShareBuilder {
	
		protected BigDecimal shareAmount;
		
		@Override
		@RosettaAttribute("shareAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("shareAmount")
		public BigDecimal getShareAmount() {
			return shareAmount;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("currency")
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder setCurrency(Currency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder setAmount(BigDecimal _amount) {
			this.amount = _amount == null ? null : _amount;
			return this;
		}
		
		@RosettaAttribute("shareAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("shareAmount")
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder setShareAmount(BigDecimal _shareAmount) {
			this.shareAmount = _shareAmount == null ? null : _shareAmount;
			return this;
		}
		
		@Override
		public MoneyWithParticipantShare build() {
			return new MoneyWithParticipantShare.MoneyWithParticipantShareImpl(this);
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getShareAmount()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder o = (MoneyWithParticipantShare.MoneyWithParticipantShareBuilder) other;
			
			
			merger.mergeBasic(getShareAmount(), o.getShareAmount(), this::setShareAmount);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MoneyWithParticipantShare _that = getType().cast(o);
		
			if (!Objects.equals(shareAmount, _that.getShareAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (shareAmount != null ? shareAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MoneyWithParticipantShareBuilder {" +
				"shareAmount=" + this.shareAmount +
			'}' + " " + super.toString();
		}
	}
}
