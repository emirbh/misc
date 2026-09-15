package fpml.consolidated.eq.shared;

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
import fpml.consolidated.eq.shared.meta.PrincipalExchangeAmountMeta;
import fpml.consolidated.shared.AmountReference;
import fpml.consolidated.shared.DeterminationMethod;
import fpml.consolidated.shared.NonNegativeMoney;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Specifies the principal exchange amount, either by explicitly defining it, or by point to an amount defined somewhere else in the swap document.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Specifies the principal exchange amount, either by explicitly defining it, or by point to an amount defined somewhere else in the swap document.
 *
 */
@RosettaDataType(value="PrincipalExchangeAmount", builder=PrincipalExchangeAmount.PrincipalExchangeAmountBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PrincipalExchangeAmount", model="fpml", builder=PrincipalExchangeAmount.PrincipalExchangeAmountBuilderImpl.class, version="2.1.1")
public interface PrincipalExchangeAmount extends RosettaModelObject {

	PrincipalExchangeAmountMeta metaData = new PrincipalExchangeAmountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to an amount defined elsewhere in the document.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to an amount defined elsewhere in the document.
	 *
	 */
	AmountReference getAmountRelativeTo();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the method according to which an amount or a date is determined.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the method according to which an amount or a date is determined.
	 *
	 */
	DeterminationMethod getDeterminationMethod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Principal exchange amount when explictly stated.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Principal exchange amount when explictly stated.
	 *
	 */
	NonNegativeMoney getPrincipalAmount();

	/*********************** Build Methods  ***********************/
	PrincipalExchangeAmount build();
	
	PrincipalExchangeAmount.PrincipalExchangeAmountBuilder toBuilder();
	
	static PrincipalExchangeAmount.PrincipalExchangeAmountBuilder builder() {
		return new PrincipalExchangeAmount.PrincipalExchangeAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PrincipalExchangeAmount> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PrincipalExchangeAmount> getType() {
		return PrincipalExchangeAmount.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("amountRelativeTo"), processor, AmountReference.class, getAmountRelativeTo());
		processRosetta(path.newSubPath("determinationMethod"), processor, DeterminationMethod.class, getDeterminationMethod());
		processRosetta(path.newSubPath("principalAmount"), processor, NonNegativeMoney.class, getPrincipalAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PrincipalExchangeAmountBuilder extends PrincipalExchangeAmount, RosettaModelObjectBuilder {
		AmountReference.AmountReferenceBuilder getOrCreateAmountRelativeTo();
		@Override
		AmountReference.AmountReferenceBuilder getAmountRelativeTo();
		DeterminationMethod.DeterminationMethodBuilder getOrCreateDeterminationMethod();
		@Override
		DeterminationMethod.DeterminationMethodBuilder getDeterminationMethod();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePrincipalAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getPrincipalAmount();
		PrincipalExchangeAmount.PrincipalExchangeAmountBuilder setAmountRelativeTo(AmountReference amountRelativeTo);
		PrincipalExchangeAmount.PrincipalExchangeAmountBuilder setDeterminationMethod(DeterminationMethod determinationMethod);
		PrincipalExchangeAmount.PrincipalExchangeAmountBuilder setPrincipalAmount(NonNegativeMoney principalAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("amountRelativeTo"), processor, AmountReference.AmountReferenceBuilder.class, getAmountRelativeTo());
			processRosetta(path.newSubPath("determinationMethod"), processor, DeterminationMethod.DeterminationMethodBuilder.class, getDeterminationMethod());
			processRosetta(path.newSubPath("principalAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPrincipalAmount());
		}
		

		PrincipalExchangeAmount.PrincipalExchangeAmountBuilder prune();
	}

	/*********************** Immutable Implementation of PrincipalExchangeAmount  ***********************/
	class PrincipalExchangeAmountImpl implements PrincipalExchangeAmount {
		private final AmountReference amountRelativeTo;
		private final DeterminationMethod determinationMethod;
		private final NonNegativeMoney principalAmount;
		
		protected PrincipalExchangeAmountImpl(PrincipalExchangeAmount.PrincipalExchangeAmountBuilder builder) {
			this.amountRelativeTo = ofNullable(builder.getAmountRelativeTo()).map(f->f.build()).orElse(null);
			this.determinationMethod = ofNullable(builder.getDeterminationMethod()).map(f->f.build()).orElse(null);
			this.principalAmount = ofNullable(builder.getPrincipalAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("amountRelativeTo")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amountRelativeTo")
		public AmountReference getAmountRelativeTo() {
			return amountRelativeTo;
		}
		
		@Override
		@RosettaAttribute("determinationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("determinationMethod")
		public DeterminationMethod getDeterminationMethod() {
			return determinationMethod;
		}
		
		@Override
		@RosettaAttribute("principalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("principalAmount")
		public NonNegativeMoney getPrincipalAmount() {
			return principalAmount;
		}
		
		@Override
		public PrincipalExchangeAmount build() {
			return this;
		}
		
		@Override
		public PrincipalExchangeAmount.PrincipalExchangeAmountBuilder toBuilder() {
			PrincipalExchangeAmount.PrincipalExchangeAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PrincipalExchangeAmount.PrincipalExchangeAmountBuilder builder) {
			ofNullable(getAmountRelativeTo()).ifPresent(builder::setAmountRelativeTo);
			ofNullable(getDeterminationMethod()).ifPresent(builder::setDeterminationMethod);
			ofNullable(getPrincipalAmount()).ifPresent(builder::setPrincipalAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PrincipalExchangeAmount _that = getType().cast(o);
		
			if (!Objects.equals(amountRelativeTo, _that.getAmountRelativeTo())) return false;
			if (!Objects.equals(determinationMethod, _that.getDeterminationMethod())) return false;
			if (!Objects.equals(principalAmount, _that.getPrincipalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amountRelativeTo != null ? amountRelativeTo.hashCode() : 0);
			_result = 31 * _result + (determinationMethod != null ? determinationMethod.hashCode() : 0);
			_result = 31 * _result + (principalAmount != null ? principalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrincipalExchangeAmount {" +
				"amountRelativeTo=" + this.amountRelativeTo + ", " +
				"determinationMethod=" + this.determinationMethod + ", " +
				"principalAmount=" + this.principalAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of PrincipalExchangeAmount  ***********************/
	class PrincipalExchangeAmountBuilderImpl implements PrincipalExchangeAmount.PrincipalExchangeAmountBuilder {
	
		protected AmountReference.AmountReferenceBuilder amountRelativeTo;
		protected DeterminationMethod.DeterminationMethodBuilder determinationMethod;
		protected NonNegativeMoney.NonNegativeMoneyBuilder principalAmount;
		
		@Override
		@RosettaAttribute("amountRelativeTo")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amountRelativeTo")
		public AmountReference.AmountReferenceBuilder getAmountRelativeTo() {
			return amountRelativeTo;
		}
		
		@Override
		public AmountReference.AmountReferenceBuilder getOrCreateAmountRelativeTo() {
			AmountReference.AmountReferenceBuilder result;
			if (amountRelativeTo!=null) {
				result = amountRelativeTo;
			}
			else {
				result = amountRelativeTo = AmountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("determinationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("determinationMethod")
		public DeterminationMethod.DeterminationMethodBuilder getDeterminationMethod() {
			return determinationMethod;
		}
		
		@Override
		public DeterminationMethod.DeterminationMethodBuilder getOrCreateDeterminationMethod() {
			DeterminationMethod.DeterminationMethodBuilder result;
			if (determinationMethod!=null) {
				result = determinationMethod;
			}
			else {
				result = determinationMethod = DeterminationMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("principalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("principalAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getPrincipalAmount() {
			return principalAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePrincipalAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (principalAmount!=null) {
				result = principalAmount;
			}
			else {
				result = principalAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("amountRelativeTo")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("amountRelativeTo")
		@Override
		public PrincipalExchangeAmount.PrincipalExchangeAmountBuilder setAmountRelativeTo(AmountReference _amountRelativeTo) {
			this.amountRelativeTo = _amountRelativeTo == null ? null : _amountRelativeTo.toBuilder();
			return this;
		}
		
		@RosettaAttribute("determinationMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("determinationMethod")
		@Override
		public PrincipalExchangeAmount.PrincipalExchangeAmountBuilder setDeterminationMethod(DeterminationMethod _determinationMethod) {
			this.determinationMethod = _determinationMethod == null ? null : _determinationMethod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("principalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("principalAmount")
		@Override
		public PrincipalExchangeAmount.PrincipalExchangeAmountBuilder setPrincipalAmount(NonNegativeMoney _principalAmount) {
			this.principalAmount = _principalAmount == null ? null : _principalAmount.toBuilder();
			return this;
		}
		
		@Override
		public PrincipalExchangeAmount build() {
			return new PrincipalExchangeAmount.PrincipalExchangeAmountImpl(this);
		}
		
		@Override
		public PrincipalExchangeAmount.PrincipalExchangeAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrincipalExchangeAmount.PrincipalExchangeAmountBuilder prune() {
			if (amountRelativeTo!=null && !amountRelativeTo.prune().hasData()) amountRelativeTo = null;
			if (determinationMethod!=null && !determinationMethod.prune().hasData()) determinationMethod = null;
			if (principalAmount!=null && !principalAmount.prune().hasData()) principalAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmountRelativeTo()!=null && getAmountRelativeTo().hasData()) return true;
			if (getDeterminationMethod()!=null && getDeterminationMethod().hasData()) return true;
			if (getPrincipalAmount()!=null && getPrincipalAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrincipalExchangeAmount.PrincipalExchangeAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PrincipalExchangeAmount.PrincipalExchangeAmountBuilder o = (PrincipalExchangeAmount.PrincipalExchangeAmountBuilder) other;
			
			merger.mergeRosetta(getAmountRelativeTo(), o.getAmountRelativeTo(), this::setAmountRelativeTo);
			merger.mergeRosetta(getDeterminationMethod(), o.getDeterminationMethod(), this::setDeterminationMethod);
			merger.mergeRosetta(getPrincipalAmount(), o.getPrincipalAmount(), this::setPrincipalAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PrincipalExchangeAmount _that = getType().cast(o);
		
			if (!Objects.equals(amountRelativeTo, _that.getAmountRelativeTo())) return false;
			if (!Objects.equals(determinationMethod, _that.getDeterminationMethod())) return false;
			if (!Objects.equals(principalAmount, _that.getPrincipalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amountRelativeTo != null ? amountRelativeTo.hashCode() : 0);
			_result = 31 * _result + (determinationMethod != null ? determinationMethod.hashCode() : 0);
			_result = 31 * _result + (principalAmount != null ? principalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrincipalExchangeAmountBuilder {" +
				"amountRelativeTo=" + this.amountRelativeTo + ", " +
				"determinationMethod=" + this.determinationMethod + ", " +
				"principalAmount=" + this.principalAmount +
			'}';
		}
	}
}
