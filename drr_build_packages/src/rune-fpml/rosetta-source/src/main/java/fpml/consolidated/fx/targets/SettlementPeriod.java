package fpml.consolidated.fx.targets;

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
import fpml.consolidated.fx.targets.meta.SettlementPeriodMeta;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

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
@RosettaDataType(value="SettlementPeriod", builder=SettlementPeriod.SettlementPeriodBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SettlementPeriod", model="fpml", builder=SettlementPeriod.SettlementPeriodBuilderImpl.class, version="2.1.1")
public interface SettlementPeriod extends RosettaModelObject {

	SettlementPeriodMeta metaData = new SettlementPeriodMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Expiry date for the settlement period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Expiry date for the settlement period.
	 *
	 */
	ZonedDateTime getExpiryDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Settlement date for the settlement period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Settlement date for the settlement period.
	 *
	 */
	ZonedDateTime getSettlementDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Notional Amount for the settlement period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Notional Amount for the settlement period.
	 *
	 */
	BigDecimal getNotionalAmount();

	/*********************** Build Methods  ***********************/
	SettlementPeriod build();
	
	SettlementPeriod.SettlementPeriodBuilder toBuilder();
	
	static SettlementPeriod.SettlementPeriodBuilder builder() {
		return new SettlementPeriod.SettlementPeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettlementPeriod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SettlementPeriod> getType() {
		return SettlementPeriod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expiryDate"), ZonedDateTime.class, getExpiryDate(), this);
		processor.processBasic(path.newSubPath("settlementDate"), ZonedDateTime.class, getSettlementDate(), this);
		processor.processBasic(path.newSubPath("notionalAmount"), BigDecimal.class, getNotionalAmount(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettlementPeriodBuilder extends SettlementPeriod, RosettaModelObjectBuilder {
		SettlementPeriod.SettlementPeriodBuilder setExpiryDate(ZonedDateTime expiryDate);
		SettlementPeriod.SettlementPeriodBuilder setSettlementDate(ZonedDateTime settlementDate);
		SettlementPeriod.SettlementPeriodBuilder setNotionalAmount(BigDecimal notionalAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expiryDate"), ZonedDateTime.class, getExpiryDate(), this);
			processor.processBasic(path.newSubPath("settlementDate"), ZonedDateTime.class, getSettlementDate(), this);
			processor.processBasic(path.newSubPath("notionalAmount"), BigDecimal.class, getNotionalAmount(), this);
		}
		

		SettlementPeriod.SettlementPeriodBuilder prune();
	}

	/*********************** Immutable Implementation of SettlementPeriod  ***********************/
	class SettlementPeriodImpl implements SettlementPeriod {
		private final ZonedDateTime expiryDate;
		private final ZonedDateTime settlementDate;
		private final BigDecimal notionalAmount;
		
		protected SettlementPeriodImpl(SettlementPeriod.SettlementPeriodBuilder builder) {
			this.expiryDate = builder.getExpiryDate();
			this.settlementDate = builder.getSettlementDate();
			this.notionalAmount = builder.getNotionalAmount();
		}
		
		@Override
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("expiryDate")
		public ZonedDateTime getExpiryDate() {
			return expiryDate;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("settlementDate")
		public ZonedDateTime getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("notionalAmount")
		public BigDecimal getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		public SettlementPeriod build() {
			return this;
		}
		
		@Override
		public SettlementPeriod.SettlementPeriodBuilder toBuilder() {
			SettlementPeriod.SettlementPeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementPeriod.SettlementPeriodBuilder builder) {
			ofNullable(getExpiryDate()).ifPresent(builder::setExpiryDate);
			ofNullable(getSettlementDate()).ifPresent(builder::setSettlementDate);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementPeriod _that = getType().cast(o);
		
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementPeriod {" +
				"expiryDate=" + this.expiryDate + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"notionalAmount=" + this.notionalAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of SettlementPeriod  ***********************/
	class SettlementPeriodBuilderImpl implements SettlementPeriod.SettlementPeriodBuilder {
	
		protected ZonedDateTime expiryDate;
		protected ZonedDateTime settlementDate;
		protected BigDecimal notionalAmount;
		
		@Override
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("expiryDate")
		public ZonedDateTime getExpiryDate() {
			return expiryDate;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("settlementDate")
		public ZonedDateTime getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("notionalAmount")
		public BigDecimal getNotionalAmount() {
			return notionalAmount;
		}
		
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("expiryDate")
		@Override
		public SettlementPeriod.SettlementPeriodBuilder setExpiryDate(ZonedDateTime _expiryDate) {
			this.expiryDate = _expiryDate == null ? null : _expiryDate;
			return this;
		}
		
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("settlementDate")
		@Override
		public SettlementPeriod.SettlementPeriodBuilder setSettlementDate(ZonedDateTime _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate;
			return this;
		}
		
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("notionalAmount")
		@Override
		public SettlementPeriod.SettlementPeriodBuilder setNotionalAmount(BigDecimal _notionalAmount) {
			this.notionalAmount = _notionalAmount == null ? null : _notionalAmount;
			return this;
		}
		
		@Override
		public SettlementPeriod build() {
			return new SettlementPeriod.SettlementPeriodImpl(this);
		}
		
		@Override
		public SettlementPeriod.SettlementPeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPeriod.SettlementPeriodBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExpiryDate()!=null) return true;
			if (getSettlementDate()!=null) return true;
			if (getNotionalAmount()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPeriod.SettlementPeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SettlementPeriod.SettlementPeriodBuilder o = (SettlementPeriod.SettlementPeriodBuilder) other;
			
			
			merger.mergeBasic(getExpiryDate(), o.getExpiryDate(), this::setExpiryDate);
			merger.mergeBasic(getSettlementDate(), o.getSettlementDate(), this::setSettlementDate);
			merger.mergeBasic(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementPeriod _that = getType().cast(o);
		
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementPeriodBuilder {" +
				"expiryDate=" + this.expiryDate + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"notionalAmount=" + this.notionalAmount +
			'}';
		}
	}
}
