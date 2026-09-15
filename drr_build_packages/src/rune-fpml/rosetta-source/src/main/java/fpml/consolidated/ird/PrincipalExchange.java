package fpml.consolidated.ird;

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
import fpml.consolidated.ird.meta.PrincipalExchangeMeta;
import fpml.consolidated.shared.Money;
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
 * Provision A type defining a principal exchange amount and adjusted exchange date. The type forms part of the cashflow representation of a swap stream.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a principal exchange amount and adjusted exchange date. The type forms part of the cashflow representation of a swap stream.
 *
 */
@RosettaDataType(value="PrincipalExchange", builder=PrincipalExchange.PrincipalExchangeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PrincipalExchange", model="fpml", builder=PrincipalExchange.PrincipalExchangeBuilderImpl.class, version="2.1.1")
public interface PrincipalExchange extends RosettaModelObject {

	PrincipalExchangeMeta metaData = new PrincipalExchangeMeta();

	/*********************** Getter Methods  ***********************/
	/**
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
	String getId();
	/**
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
	ZonedDateTime getUnadjustedPrincipalExchangeDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The principal exchange date. This date should already be adjusted for any applicable business day convention.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The principal exchange date. This date should already be adjusted for any applicable business day convention.
	 *
	 */
	ZonedDateTime getAdjustedPrincipalExchangeDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The principal exchange amount. This amount should be positive if the stream payer is paying the exchange amount and signed negative if they are receiving it.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The principal exchange amount. This amount should be positive if the stream payer is paying the exchange amount and signed negative if they are receiving it.
	 *
	 */
	BigDecimal getPrincipalExchangeAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The value representing the discount factor used to calculate the present value of the principal exchange amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The value representing the discount factor used to calculate the present value of the principal exchange amount.
	 *
	 */
	BigDecimal getDiscountFactor();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The amount representing the present value of the principal exchange.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The amount representing the present value of the principal exchange.
	 *
	 */
	Money getPresentValuePrincipalExchangeAmount();

	/*********************** Build Methods  ***********************/
	PrincipalExchange build();
	
	PrincipalExchange.PrincipalExchangeBuilder toBuilder();
	
	static PrincipalExchange.PrincipalExchangeBuilder builder() {
		return new PrincipalExchange.PrincipalExchangeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PrincipalExchange> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PrincipalExchange> getType() {
		return PrincipalExchange.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("unadjustedPrincipalExchangeDate"), ZonedDateTime.class, getUnadjustedPrincipalExchangeDate(), this);
		processor.processBasic(path.newSubPath("adjustedPrincipalExchangeDate"), ZonedDateTime.class, getAdjustedPrincipalExchangeDate(), this);
		processor.processBasic(path.newSubPath("principalExchangeAmount"), BigDecimal.class, getPrincipalExchangeAmount(), this);
		processor.processBasic(path.newSubPath("discountFactor"), BigDecimal.class, getDiscountFactor(), this);
		processRosetta(path.newSubPath("presentValuePrincipalExchangeAmount"), processor, Money.class, getPresentValuePrincipalExchangeAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PrincipalExchangeBuilder extends PrincipalExchange, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreatePresentValuePrincipalExchangeAmount();
		@Override
		Money.MoneyBuilder getPresentValuePrincipalExchangeAmount();
		PrincipalExchange.PrincipalExchangeBuilder setId(String id);
		PrincipalExchange.PrincipalExchangeBuilder setUnadjustedPrincipalExchangeDate(ZonedDateTime unadjustedPrincipalExchangeDate);
		PrincipalExchange.PrincipalExchangeBuilder setAdjustedPrincipalExchangeDate(ZonedDateTime adjustedPrincipalExchangeDate);
		PrincipalExchange.PrincipalExchangeBuilder setPrincipalExchangeAmount(BigDecimal principalExchangeAmount);
		PrincipalExchange.PrincipalExchangeBuilder setDiscountFactor(BigDecimal discountFactor);
		PrincipalExchange.PrincipalExchangeBuilder setPresentValuePrincipalExchangeAmount(Money presentValuePrincipalExchangeAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("unadjustedPrincipalExchangeDate"), ZonedDateTime.class, getUnadjustedPrincipalExchangeDate(), this);
			processor.processBasic(path.newSubPath("adjustedPrincipalExchangeDate"), ZonedDateTime.class, getAdjustedPrincipalExchangeDate(), this);
			processor.processBasic(path.newSubPath("principalExchangeAmount"), BigDecimal.class, getPrincipalExchangeAmount(), this);
			processor.processBasic(path.newSubPath("discountFactor"), BigDecimal.class, getDiscountFactor(), this);
			processRosetta(path.newSubPath("presentValuePrincipalExchangeAmount"), processor, Money.MoneyBuilder.class, getPresentValuePrincipalExchangeAmount());
		}
		

		PrincipalExchange.PrincipalExchangeBuilder prune();
	}

	/*********************** Immutable Implementation of PrincipalExchange  ***********************/
	class PrincipalExchangeImpl implements PrincipalExchange {
		private final String id;
		private final ZonedDateTime unadjustedPrincipalExchangeDate;
		private final ZonedDateTime adjustedPrincipalExchangeDate;
		private final BigDecimal principalExchangeAmount;
		private final BigDecimal discountFactor;
		private final Money presentValuePrincipalExchangeAmount;
		
		protected PrincipalExchangeImpl(PrincipalExchange.PrincipalExchangeBuilder builder) {
			this.id = builder.getId();
			this.unadjustedPrincipalExchangeDate = builder.getUnadjustedPrincipalExchangeDate();
			this.adjustedPrincipalExchangeDate = builder.getAdjustedPrincipalExchangeDate();
			this.principalExchangeAmount = builder.getPrincipalExchangeAmount();
			this.discountFactor = builder.getDiscountFactor();
			this.presentValuePrincipalExchangeAmount = ofNullable(builder.getPresentValuePrincipalExchangeAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("unadjustedPrincipalExchangeDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unadjustedPrincipalExchangeDate")
		public ZonedDateTime getUnadjustedPrincipalExchangeDate() {
			return unadjustedPrincipalExchangeDate;
		}
		
		@Override
		@RosettaAttribute("adjustedPrincipalExchangeDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedPrincipalExchangeDate")
		public ZonedDateTime getAdjustedPrincipalExchangeDate() {
			return adjustedPrincipalExchangeDate;
		}
		
		@Override
		@RosettaAttribute("principalExchangeAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("principalExchangeAmount")
		public BigDecimal getPrincipalExchangeAmount() {
			return principalExchangeAmount;
		}
		
		@Override
		@RosettaAttribute("discountFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("discountFactor")
		public BigDecimal getDiscountFactor() {
			return discountFactor;
		}
		
		@Override
		@RosettaAttribute("presentValuePrincipalExchangeAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("presentValuePrincipalExchangeAmount")
		public Money getPresentValuePrincipalExchangeAmount() {
			return presentValuePrincipalExchangeAmount;
		}
		
		@Override
		public PrincipalExchange build() {
			return this;
		}
		
		@Override
		public PrincipalExchange.PrincipalExchangeBuilder toBuilder() {
			PrincipalExchange.PrincipalExchangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PrincipalExchange.PrincipalExchangeBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getUnadjustedPrincipalExchangeDate()).ifPresent(builder::setUnadjustedPrincipalExchangeDate);
			ofNullable(getAdjustedPrincipalExchangeDate()).ifPresent(builder::setAdjustedPrincipalExchangeDate);
			ofNullable(getPrincipalExchangeAmount()).ifPresent(builder::setPrincipalExchangeAmount);
			ofNullable(getDiscountFactor()).ifPresent(builder::setDiscountFactor);
			ofNullable(getPresentValuePrincipalExchangeAmount()).ifPresent(builder::setPresentValuePrincipalExchangeAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PrincipalExchange _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(unadjustedPrincipalExchangeDate, _that.getUnadjustedPrincipalExchangeDate())) return false;
			if (!Objects.equals(adjustedPrincipalExchangeDate, _that.getAdjustedPrincipalExchangeDate())) return false;
			if (!Objects.equals(principalExchangeAmount, _that.getPrincipalExchangeAmount())) return false;
			if (!Objects.equals(discountFactor, _that.getDiscountFactor())) return false;
			if (!Objects.equals(presentValuePrincipalExchangeAmount, _that.getPresentValuePrincipalExchangeAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (unadjustedPrincipalExchangeDate != null ? unadjustedPrincipalExchangeDate.hashCode() : 0);
			_result = 31 * _result + (adjustedPrincipalExchangeDate != null ? adjustedPrincipalExchangeDate.hashCode() : 0);
			_result = 31 * _result + (principalExchangeAmount != null ? principalExchangeAmount.hashCode() : 0);
			_result = 31 * _result + (discountFactor != null ? discountFactor.hashCode() : 0);
			_result = 31 * _result + (presentValuePrincipalExchangeAmount != null ? presentValuePrincipalExchangeAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrincipalExchange {" +
				"id=" + this.id + ", " +
				"unadjustedPrincipalExchangeDate=" + this.unadjustedPrincipalExchangeDate + ", " +
				"adjustedPrincipalExchangeDate=" + this.adjustedPrincipalExchangeDate + ", " +
				"principalExchangeAmount=" + this.principalExchangeAmount + ", " +
				"discountFactor=" + this.discountFactor + ", " +
				"presentValuePrincipalExchangeAmount=" + this.presentValuePrincipalExchangeAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of PrincipalExchange  ***********************/
	class PrincipalExchangeBuilderImpl implements PrincipalExchange.PrincipalExchangeBuilder {
	
		protected String id;
		protected ZonedDateTime unadjustedPrincipalExchangeDate;
		protected ZonedDateTime adjustedPrincipalExchangeDate;
		protected BigDecimal principalExchangeAmount;
		protected BigDecimal discountFactor;
		protected Money.MoneyBuilder presentValuePrincipalExchangeAmount;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("unadjustedPrincipalExchangeDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unadjustedPrincipalExchangeDate")
		public ZonedDateTime getUnadjustedPrincipalExchangeDate() {
			return unadjustedPrincipalExchangeDate;
		}
		
		@Override
		@RosettaAttribute("adjustedPrincipalExchangeDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedPrincipalExchangeDate")
		public ZonedDateTime getAdjustedPrincipalExchangeDate() {
			return adjustedPrincipalExchangeDate;
		}
		
		@Override
		@RosettaAttribute("principalExchangeAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("principalExchangeAmount")
		public BigDecimal getPrincipalExchangeAmount() {
			return principalExchangeAmount;
		}
		
		@Override
		@RosettaAttribute("discountFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("discountFactor")
		public BigDecimal getDiscountFactor() {
			return discountFactor;
		}
		
		@Override
		@RosettaAttribute("presentValuePrincipalExchangeAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("presentValuePrincipalExchangeAmount")
		public Money.MoneyBuilder getPresentValuePrincipalExchangeAmount() {
			return presentValuePrincipalExchangeAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreatePresentValuePrincipalExchangeAmount() {
			Money.MoneyBuilder result;
			if (presentValuePrincipalExchangeAmount!=null) {
				result = presentValuePrincipalExchangeAmount;
			}
			else {
				result = presentValuePrincipalExchangeAmount = Money.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public PrincipalExchange.PrincipalExchangeBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("unadjustedPrincipalExchangeDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unadjustedPrincipalExchangeDate")
		@Override
		public PrincipalExchange.PrincipalExchangeBuilder setUnadjustedPrincipalExchangeDate(ZonedDateTime _unadjustedPrincipalExchangeDate) {
			this.unadjustedPrincipalExchangeDate = _unadjustedPrincipalExchangeDate == null ? null : _unadjustedPrincipalExchangeDate;
			return this;
		}
		
		@RosettaAttribute("adjustedPrincipalExchangeDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustedPrincipalExchangeDate")
		@Override
		public PrincipalExchange.PrincipalExchangeBuilder setAdjustedPrincipalExchangeDate(ZonedDateTime _adjustedPrincipalExchangeDate) {
			this.adjustedPrincipalExchangeDate = _adjustedPrincipalExchangeDate == null ? null : _adjustedPrincipalExchangeDate;
			return this;
		}
		
		@RosettaAttribute("principalExchangeAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("principalExchangeAmount")
		@Override
		public PrincipalExchange.PrincipalExchangeBuilder setPrincipalExchangeAmount(BigDecimal _principalExchangeAmount) {
			this.principalExchangeAmount = _principalExchangeAmount == null ? null : _principalExchangeAmount;
			return this;
		}
		
		@RosettaAttribute("discountFactor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("discountFactor")
		@Override
		public PrincipalExchange.PrincipalExchangeBuilder setDiscountFactor(BigDecimal _discountFactor) {
			this.discountFactor = _discountFactor == null ? null : _discountFactor;
			return this;
		}
		
		@RosettaAttribute("presentValuePrincipalExchangeAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("presentValuePrincipalExchangeAmount")
		@Override
		public PrincipalExchange.PrincipalExchangeBuilder setPresentValuePrincipalExchangeAmount(Money _presentValuePrincipalExchangeAmount) {
			this.presentValuePrincipalExchangeAmount = _presentValuePrincipalExchangeAmount == null ? null : _presentValuePrincipalExchangeAmount.toBuilder();
			return this;
		}
		
		@Override
		public PrincipalExchange build() {
			return new PrincipalExchange.PrincipalExchangeImpl(this);
		}
		
		@Override
		public PrincipalExchange.PrincipalExchangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrincipalExchange.PrincipalExchangeBuilder prune() {
			if (presentValuePrincipalExchangeAmount!=null && !presentValuePrincipalExchangeAmount.prune().hasData()) presentValuePrincipalExchangeAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getUnadjustedPrincipalExchangeDate()!=null) return true;
			if (getAdjustedPrincipalExchangeDate()!=null) return true;
			if (getPrincipalExchangeAmount()!=null) return true;
			if (getDiscountFactor()!=null) return true;
			if (getPresentValuePrincipalExchangeAmount()!=null && getPresentValuePrincipalExchangeAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrincipalExchange.PrincipalExchangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PrincipalExchange.PrincipalExchangeBuilder o = (PrincipalExchange.PrincipalExchangeBuilder) other;
			
			merger.mergeRosetta(getPresentValuePrincipalExchangeAmount(), o.getPresentValuePrincipalExchangeAmount(), this::setPresentValuePrincipalExchangeAmount);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getUnadjustedPrincipalExchangeDate(), o.getUnadjustedPrincipalExchangeDate(), this::setUnadjustedPrincipalExchangeDate);
			merger.mergeBasic(getAdjustedPrincipalExchangeDate(), o.getAdjustedPrincipalExchangeDate(), this::setAdjustedPrincipalExchangeDate);
			merger.mergeBasic(getPrincipalExchangeAmount(), o.getPrincipalExchangeAmount(), this::setPrincipalExchangeAmount);
			merger.mergeBasic(getDiscountFactor(), o.getDiscountFactor(), this::setDiscountFactor);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PrincipalExchange _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(unadjustedPrincipalExchangeDate, _that.getUnadjustedPrincipalExchangeDate())) return false;
			if (!Objects.equals(adjustedPrincipalExchangeDate, _that.getAdjustedPrincipalExchangeDate())) return false;
			if (!Objects.equals(principalExchangeAmount, _that.getPrincipalExchangeAmount())) return false;
			if (!Objects.equals(discountFactor, _that.getDiscountFactor())) return false;
			if (!Objects.equals(presentValuePrincipalExchangeAmount, _that.getPresentValuePrincipalExchangeAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (unadjustedPrincipalExchangeDate != null ? unadjustedPrincipalExchangeDate.hashCode() : 0);
			_result = 31 * _result + (adjustedPrincipalExchangeDate != null ? adjustedPrincipalExchangeDate.hashCode() : 0);
			_result = 31 * _result + (principalExchangeAmount != null ? principalExchangeAmount.hashCode() : 0);
			_result = 31 * _result + (discountFactor != null ? discountFactor.hashCode() : 0);
			_result = 31 * _result + (presentValuePrincipalExchangeAmount != null ? presentValuePrincipalExchangeAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrincipalExchangeBuilder {" +
				"id=" + this.id + ", " +
				"unadjustedPrincipalExchangeDate=" + this.unadjustedPrincipalExchangeDate + ", " +
				"adjustedPrincipalExchangeDate=" + this.adjustedPrincipalExchangeDate + ", " +
				"principalExchangeAmount=" + this.principalExchangeAmount + ", " +
				"discountFactor=" + this.discountFactor + ", " +
				"presentValuePrincipalExchangeAmount=" + this.presentValuePrincipalExchangeAmount +
			'}';
		}
	}
}
