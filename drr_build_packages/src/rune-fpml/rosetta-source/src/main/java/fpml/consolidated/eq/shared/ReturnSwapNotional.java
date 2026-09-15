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
import fpml.consolidated.eq.shared.meta.ReturnSwapNotionalMeta;
import fpml.consolidated.shared.DeterminationMethod;
import fpml.consolidated.shared.DeterminationMethodReference;
import fpml.consolidated.shared.NotionalAmount;
import fpml.consolidated.shared.ReturnSwapNotionalAmountReference;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Specifies the notional of return type swap. When used in the equity leg, the definition will typically combine the actual amount (using the notional component defined by the FpML industry group) and the determination method. When used in the interest leg, the definition will typically point to the definition of the equity leg.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Specifies the notional of return type swap. When used in the equity leg, the definition will typically combine the actual amount (using the notional component defined by the FpML industry group) and the determination method. When used in the interest leg, the definition will typically point to the definition of the equity leg.
 *
 */
@RosettaDataType(value="ReturnSwapNotional", builder=ReturnSwapNotional.ReturnSwapNotionalBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ReturnSwapNotional", model="fpml", builder=ReturnSwapNotional.ReturnSwapNotionalBuilderImpl.class, version="2.1.1")
public interface ReturnSwapNotional extends RosettaModelObject {

	ReturnSwapNotionalMeta metaData = new ReturnSwapNotionalMeta();

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
	 * Provision A reference to the return swap notional amount defined elsewhere in this document.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the return swap notional amount defined elsewhere in this document.
	 *
	 */
	ReturnSwapNotionalAmountReference getRelativeNotionalAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the return swap notional determination method defined elsewhere in this document.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the return swap notional determination method defined elsewhere in this document.
	 *
	 */
	DeterminationMethodReference getRelativeDeterminationMethod();
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
	 * Provision The notional amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The notional amount.
	 *
	 */
	NotionalAmount getNotionalAmount();

	/*********************** Build Methods  ***********************/
	ReturnSwapNotional build();
	
	ReturnSwapNotional.ReturnSwapNotionalBuilder toBuilder();
	
	static ReturnSwapNotional.ReturnSwapNotionalBuilder builder() {
		return new ReturnSwapNotional.ReturnSwapNotionalBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReturnSwapNotional> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReturnSwapNotional> getType() {
		return ReturnSwapNotional.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("relativeNotionalAmount"), processor, ReturnSwapNotionalAmountReference.class, getRelativeNotionalAmount());
		processRosetta(path.newSubPath("relativeDeterminationMethod"), processor, DeterminationMethodReference.class, getRelativeDeterminationMethod());
		processRosetta(path.newSubPath("determinationMethod"), processor, DeterminationMethod.class, getDeterminationMethod());
		processRosetta(path.newSubPath("notionalAmount"), processor, NotionalAmount.class, getNotionalAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReturnSwapNotionalBuilder extends ReturnSwapNotional, RosettaModelObjectBuilder {
		ReturnSwapNotionalAmountReference.ReturnSwapNotionalAmountReferenceBuilder getOrCreateRelativeNotionalAmount();
		@Override
		ReturnSwapNotionalAmountReference.ReturnSwapNotionalAmountReferenceBuilder getRelativeNotionalAmount();
		DeterminationMethodReference.DeterminationMethodReferenceBuilder getOrCreateRelativeDeterminationMethod();
		@Override
		DeterminationMethodReference.DeterminationMethodReferenceBuilder getRelativeDeterminationMethod();
		DeterminationMethod.DeterminationMethodBuilder getOrCreateDeterminationMethod();
		@Override
		DeterminationMethod.DeterminationMethodBuilder getDeterminationMethod();
		NotionalAmount.NotionalAmountBuilder getOrCreateNotionalAmount();
		@Override
		NotionalAmount.NotionalAmountBuilder getNotionalAmount();
		ReturnSwapNotional.ReturnSwapNotionalBuilder setId(String id);
		ReturnSwapNotional.ReturnSwapNotionalBuilder setRelativeNotionalAmount(ReturnSwapNotionalAmountReference relativeNotionalAmount);
		ReturnSwapNotional.ReturnSwapNotionalBuilder setRelativeDeterminationMethod(DeterminationMethodReference relativeDeterminationMethod);
		ReturnSwapNotional.ReturnSwapNotionalBuilder setDeterminationMethod(DeterminationMethod determinationMethod);
		ReturnSwapNotional.ReturnSwapNotionalBuilder setNotionalAmount(NotionalAmount notionalAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("relativeNotionalAmount"), processor, ReturnSwapNotionalAmountReference.ReturnSwapNotionalAmountReferenceBuilder.class, getRelativeNotionalAmount());
			processRosetta(path.newSubPath("relativeDeterminationMethod"), processor, DeterminationMethodReference.DeterminationMethodReferenceBuilder.class, getRelativeDeterminationMethod());
			processRosetta(path.newSubPath("determinationMethod"), processor, DeterminationMethod.DeterminationMethodBuilder.class, getDeterminationMethod());
			processRosetta(path.newSubPath("notionalAmount"), processor, NotionalAmount.NotionalAmountBuilder.class, getNotionalAmount());
		}
		

		ReturnSwapNotional.ReturnSwapNotionalBuilder prune();
	}

	/*********************** Immutable Implementation of ReturnSwapNotional  ***********************/
	class ReturnSwapNotionalImpl implements ReturnSwapNotional {
		private final String id;
		private final ReturnSwapNotionalAmountReference relativeNotionalAmount;
		private final DeterminationMethodReference relativeDeterminationMethod;
		private final DeterminationMethod determinationMethod;
		private final NotionalAmount notionalAmount;
		
		protected ReturnSwapNotionalImpl(ReturnSwapNotional.ReturnSwapNotionalBuilder builder) {
			this.id = builder.getId();
			this.relativeNotionalAmount = ofNullable(builder.getRelativeNotionalAmount()).map(f->f.build()).orElse(null);
			this.relativeDeterminationMethod = ofNullable(builder.getRelativeDeterminationMethod()).map(f->f.build()).orElse(null);
			this.determinationMethod = ofNullable(builder.getDeterminationMethod()).map(f->f.build()).orElse(null);
			this.notionalAmount = ofNullable(builder.getNotionalAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("relativeNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relativeNotionalAmount")
		public ReturnSwapNotionalAmountReference getRelativeNotionalAmount() {
			return relativeNotionalAmount;
		}
		
		@Override
		@RosettaAttribute("relativeDeterminationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relativeDeterminationMethod")
		public DeterminationMethodReference getRelativeDeterminationMethod() {
			return relativeDeterminationMethod;
		}
		
		@Override
		@RosettaAttribute("determinationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("determinationMethod")
		public DeterminationMethod getDeterminationMethod() {
			return determinationMethod;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalAmount")
		public NotionalAmount getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		public ReturnSwapNotional build() {
			return this;
		}
		
		@Override
		public ReturnSwapNotional.ReturnSwapNotionalBuilder toBuilder() {
			ReturnSwapNotional.ReturnSwapNotionalBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReturnSwapNotional.ReturnSwapNotionalBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getRelativeNotionalAmount()).ifPresent(builder::setRelativeNotionalAmount);
			ofNullable(getRelativeDeterminationMethod()).ifPresent(builder::setRelativeDeterminationMethod);
			ofNullable(getDeterminationMethod()).ifPresent(builder::setDeterminationMethod);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReturnSwapNotional _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(relativeNotionalAmount, _that.getRelativeNotionalAmount())) return false;
			if (!Objects.equals(relativeDeterminationMethod, _that.getRelativeDeterminationMethod())) return false;
			if (!Objects.equals(determinationMethod, _that.getDeterminationMethod())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (relativeNotionalAmount != null ? relativeNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (relativeDeterminationMethod != null ? relativeDeterminationMethod.hashCode() : 0);
			_result = 31 * _result + (determinationMethod != null ? determinationMethod.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnSwapNotional {" +
				"id=" + this.id + ", " +
				"relativeNotionalAmount=" + this.relativeNotionalAmount + ", " +
				"relativeDeterminationMethod=" + this.relativeDeterminationMethod + ", " +
				"determinationMethod=" + this.determinationMethod + ", " +
				"notionalAmount=" + this.notionalAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of ReturnSwapNotional  ***********************/
	class ReturnSwapNotionalBuilderImpl implements ReturnSwapNotional.ReturnSwapNotionalBuilder {
	
		protected String id;
		protected ReturnSwapNotionalAmountReference.ReturnSwapNotionalAmountReferenceBuilder relativeNotionalAmount;
		protected DeterminationMethodReference.DeterminationMethodReferenceBuilder relativeDeterminationMethod;
		protected DeterminationMethod.DeterminationMethodBuilder determinationMethod;
		protected NotionalAmount.NotionalAmountBuilder notionalAmount;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("relativeNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relativeNotionalAmount")
		public ReturnSwapNotionalAmountReference.ReturnSwapNotionalAmountReferenceBuilder getRelativeNotionalAmount() {
			return relativeNotionalAmount;
		}
		
		@Override
		public ReturnSwapNotionalAmountReference.ReturnSwapNotionalAmountReferenceBuilder getOrCreateRelativeNotionalAmount() {
			ReturnSwapNotionalAmountReference.ReturnSwapNotionalAmountReferenceBuilder result;
			if (relativeNotionalAmount!=null) {
				result = relativeNotionalAmount;
			}
			else {
				result = relativeNotionalAmount = ReturnSwapNotionalAmountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relativeDeterminationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relativeDeterminationMethod")
		public DeterminationMethodReference.DeterminationMethodReferenceBuilder getRelativeDeterminationMethod() {
			return relativeDeterminationMethod;
		}
		
		@Override
		public DeterminationMethodReference.DeterminationMethodReferenceBuilder getOrCreateRelativeDeterminationMethod() {
			DeterminationMethodReference.DeterminationMethodReferenceBuilder result;
			if (relativeDeterminationMethod!=null) {
				result = relativeDeterminationMethod;
			}
			else {
				result = relativeDeterminationMethod = DeterminationMethodReference.builder();
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
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalAmount")
		public NotionalAmount.NotionalAmountBuilder getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		public NotionalAmount.NotionalAmountBuilder getOrCreateNotionalAmount() {
			NotionalAmount.NotionalAmountBuilder result;
			if (notionalAmount!=null) {
				result = notionalAmount;
			}
			else {
				result = notionalAmount = NotionalAmount.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public ReturnSwapNotional.ReturnSwapNotionalBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("relativeNotionalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("relativeNotionalAmount")
		@Override
		public ReturnSwapNotional.ReturnSwapNotionalBuilder setRelativeNotionalAmount(ReturnSwapNotionalAmountReference _relativeNotionalAmount) {
			this.relativeNotionalAmount = _relativeNotionalAmount == null ? null : _relativeNotionalAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relativeDeterminationMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("relativeDeterminationMethod")
		@Override
		public ReturnSwapNotional.ReturnSwapNotionalBuilder setRelativeDeterminationMethod(DeterminationMethodReference _relativeDeterminationMethod) {
			this.relativeDeterminationMethod = _relativeDeterminationMethod == null ? null : _relativeDeterminationMethod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("determinationMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("determinationMethod")
		@Override
		public ReturnSwapNotional.ReturnSwapNotionalBuilder setDeterminationMethod(DeterminationMethod _determinationMethod) {
			this.determinationMethod = _determinationMethod == null ? null : _determinationMethod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalAmount")
		@Override
		public ReturnSwapNotional.ReturnSwapNotionalBuilder setNotionalAmount(NotionalAmount _notionalAmount) {
			this.notionalAmount = _notionalAmount == null ? null : _notionalAmount.toBuilder();
			return this;
		}
		
		@Override
		public ReturnSwapNotional build() {
			return new ReturnSwapNotional.ReturnSwapNotionalImpl(this);
		}
		
		@Override
		public ReturnSwapNotional.ReturnSwapNotionalBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnSwapNotional.ReturnSwapNotionalBuilder prune() {
			if (relativeNotionalAmount!=null && !relativeNotionalAmount.prune().hasData()) relativeNotionalAmount = null;
			if (relativeDeterminationMethod!=null && !relativeDeterminationMethod.prune().hasData()) relativeDeterminationMethod = null;
			if (determinationMethod!=null && !determinationMethod.prune().hasData()) determinationMethod = null;
			if (notionalAmount!=null && !notionalAmount.prune().hasData()) notionalAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getRelativeNotionalAmount()!=null && getRelativeNotionalAmount().hasData()) return true;
			if (getRelativeDeterminationMethod()!=null && getRelativeDeterminationMethod().hasData()) return true;
			if (getDeterminationMethod()!=null && getDeterminationMethod().hasData()) return true;
			if (getNotionalAmount()!=null && getNotionalAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnSwapNotional.ReturnSwapNotionalBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReturnSwapNotional.ReturnSwapNotionalBuilder o = (ReturnSwapNotional.ReturnSwapNotionalBuilder) other;
			
			merger.mergeRosetta(getRelativeNotionalAmount(), o.getRelativeNotionalAmount(), this::setRelativeNotionalAmount);
			merger.mergeRosetta(getRelativeDeterminationMethod(), o.getRelativeDeterminationMethod(), this::setRelativeDeterminationMethod);
			merger.mergeRosetta(getDeterminationMethod(), o.getDeterminationMethod(), this::setDeterminationMethod);
			merger.mergeRosetta(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReturnSwapNotional _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(relativeNotionalAmount, _that.getRelativeNotionalAmount())) return false;
			if (!Objects.equals(relativeDeterminationMethod, _that.getRelativeDeterminationMethod())) return false;
			if (!Objects.equals(determinationMethod, _that.getDeterminationMethod())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (relativeNotionalAmount != null ? relativeNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (relativeDeterminationMethod != null ? relativeDeterminationMethod.hashCode() : 0);
			_result = 31 * _result + (determinationMethod != null ? determinationMethod.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnSwapNotionalBuilder {" +
				"id=" + this.id + ", " +
				"relativeNotionalAmount=" + this.relativeNotionalAmount + ", " +
				"relativeDeterminationMethod=" + this.relativeDeterminationMethod + ", " +
				"determinationMethod=" + this.determinationMethod + ", " +
				"notionalAmount=" + this.notionalAmount +
			'}';
		}
	}
}
