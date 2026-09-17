package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.CollateralAccessBreachMeta;
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
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify Collateral Access Breach language.
 * @version 6.23.0
 */
@RosettaDataType(value="CollateralAccessBreach", builder=CollateralAccessBreach.CollateralAccessBreachBuilderImpl.class, version="6.23.0")
@RuneDataType(value="CollateralAccessBreach", model="cdm", builder=CollateralAccessBreach.CollateralAccessBreachBuilderImpl.class, version="6.23.0")
public interface CollateralAccessBreach extends RosettaModelObject {

	CollateralAccessBreachMeta metaData = new CollateralAccessBreachMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Collateral Access Breach terms are applicable when True and not applicable when False.
	 */
	Boolean getIsApplicable();
	/**
	 * Determination of whether the Collateral Access Breach end date is a number of days (True) or specified (False).
	 */
	Boolean getCabEndDateElection();
	/**
	 * The business days following the related Collateral Access Breach when the additional terms end.
	 */
	BigDecimal getCabEndDate();
	/**
	 * Specific terms for when Collateral Access Breach terms end.
	 */
	String getCabEndDateTerms();

	/*********************** Build Methods  ***********************/
	CollateralAccessBreach build();
	
	CollateralAccessBreach.CollateralAccessBreachBuilder toBuilder();
	
	static CollateralAccessBreach.CollateralAccessBreachBuilder builder() {
		return new CollateralAccessBreach.CollateralAccessBreachBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralAccessBreach> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CollateralAccessBreach> getType() {
		return CollateralAccessBreach.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
		processor.processBasic(path.newSubPath("cabEndDateElection"), Boolean.class, getCabEndDateElection(), this);
		processor.processBasic(path.newSubPath("cabEndDate"), BigDecimal.class, getCabEndDate(), this);
		processor.processBasic(path.newSubPath("cabEndDateTerms"), String.class, getCabEndDateTerms(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralAccessBreachBuilder extends CollateralAccessBreach, RosettaModelObjectBuilder {
		CollateralAccessBreach.CollateralAccessBreachBuilder setIsApplicable(Boolean isApplicable);
		CollateralAccessBreach.CollateralAccessBreachBuilder setCabEndDateElection(Boolean cabEndDateElection);
		CollateralAccessBreach.CollateralAccessBreachBuilder setCabEndDate(BigDecimal cabEndDate);
		CollateralAccessBreach.CollateralAccessBreachBuilder setCabEndDateTerms(String cabEndDateTerms);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
			processor.processBasic(path.newSubPath("cabEndDateElection"), Boolean.class, getCabEndDateElection(), this);
			processor.processBasic(path.newSubPath("cabEndDate"), BigDecimal.class, getCabEndDate(), this);
			processor.processBasic(path.newSubPath("cabEndDateTerms"), String.class, getCabEndDateTerms(), this);
		}
		

		CollateralAccessBreach.CollateralAccessBreachBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralAccessBreach  ***********************/
	class CollateralAccessBreachImpl implements CollateralAccessBreach {
		private final Boolean isApplicable;
		private final Boolean cabEndDateElection;
		private final BigDecimal cabEndDate;
		private final String cabEndDateTerms;
		
		protected CollateralAccessBreachImpl(CollateralAccessBreach.CollateralAccessBreachBuilder builder) {
			this.isApplicable = builder.getIsApplicable();
			this.cabEndDateElection = builder.getCabEndDateElection();
			this.cabEndDate = builder.getCabEndDate();
			this.cabEndDateTerms = builder.getCabEndDateTerms();
		}
		
		@Override
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isApplicable")
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		@RosettaAttribute("cabEndDateElection")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cabEndDateElection")
		public Boolean getCabEndDateElection() {
			return cabEndDateElection;
		}
		
		@Override
		@RosettaAttribute("cabEndDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cabEndDate")
		public BigDecimal getCabEndDate() {
			return cabEndDate;
		}
		
		@Override
		@RosettaAttribute("cabEndDateTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cabEndDateTerms")
		public String getCabEndDateTerms() {
			return cabEndDateTerms;
		}
		
		@Override
		public CollateralAccessBreach build() {
			return this;
		}
		
		@Override
		public CollateralAccessBreach.CollateralAccessBreachBuilder toBuilder() {
			CollateralAccessBreach.CollateralAccessBreachBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralAccessBreach.CollateralAccessBreachBuilder builder) {
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
			ofNullable(getCabEndDateElection()).ifPresent(builder::setCabEndDateElection);
			ofNullable(getCabEndDate()).ifPresent(builder::setCabEndDate);
			ofNullable(getCabEndDateTerms()).ifPresent(builder::setCabEndDateTerms);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralAccessBreach _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(cabEndDateElection, _that.getCabEndDateElection())) return false;
			if (!Objects.equals(cabEndDate, _that.getCabEndDate())) return false;
			if (!Objects.equals(cabEndDateTerms, _that.getCabEndDateTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (cabEndDateElection != null ? cabEndDateElection.hashCode() : 0);
			_result = 31 * _result + (cabEndDate != null ? cabEndDate.hashCode() : 0);
			_result = 31 * _result + (cabEndDateTerms != null ? cabEndDateTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralAccessBreach {" +
				"isApplicable=" + this.isApplicable + ", " +
				"cabEndDateElection=" + this.cabEndDateElection + ", " +
				"cabEndDate=" + this.cabEndDate + ", " +
				"cabEndDateTerms=" + this.cabEndDateTerms +
			'}';
		}
	}

	/*********************** Builder Implementation of CollateralAccessBreach  ***********************/
	class CollateralAccessBreachBuilderImpl implements CollateralAccessBreach.CollateralAccessBreachBuilder {
	
		protected Boolean isApplicable;
		protected Boolean cabEndDateElection;
		protected BigDecimal cabEndDate;
		protected String cabEndDateTerms;
		
		@Override
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isApplicable")
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		@RosettaAttribute("cabEndDateElection")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cabEndDateElection")
		public Boolean getCabEndDateElection() {
			return cabEndDateElection;
		}
		
		@Override
		@RosettaAttribute("cabEndDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cabEndDate")
		public BigDecimal getCabEndDate() {
			return cabEndDate;
		}
		
		@Override
		@RosettaAttribute("cabEndDateTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cabEndDateTerms")
		public String getCabEndDateTerms() {
			return cabEndDateTerms;
		}
		
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("isApplicable")
		@Override
		public CollateralAccessBreach.CollateralAccessBreachBuilder setIsApplicable(Boolean _isApplicable) {
			this.isApplicable = _isApplicable == null ? null : _isApplicable;
			return this;
		}
		
		@RosettaAttribute("cabEndDateElection")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cabEndDateElection")
		@Override
		public CollateralAccessBreach.CollateralAccessBreachBuilder setCabEndDateElection(Boolean _cabEndDateElection) {
			this.cabEndDateElection = _cabEndDateElection == null ? null : _cabEndDateElection;
			return this;
		}
		
		@RosettaAttribute("cabEndDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cabEndDate")
		@Override
		public CollateralAccessBreach.CollateralAccessBreachBuilder setCabEndDate(BigDecimal _cabEndDate) {
			this.cabEndDate = _cabEndDate == null ? null : _cabEndDate;
			return this;
		}
		
		@RosettaAttribute("cabEndDateTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cabEndDateTerms")
		@Override
		public CollateralAccessBreach.CollateralAccessBreachBuilder setCabEndDateTerms(String _cabEndDateTerms) {
			this.cabEndDateTerms = _cabEndDateTerms == null ? null : _cabEndDateTerms;
			return this;
		}
		
		@Override
		public CollateralAccessBreach build() {
			return new CollateralAccessBreach.CollateralAccessBreachImpl(this);
		}
		
		@Override
		public CollateralAccessBreach.CollateralAccessBreachBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralAccessBreach.CollateralAccessBreachBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIsApplicable()!=null) return true;
			if (getCabEndDateElection()!=null) return true;
			if (getCabEndDate()!=null) return true;
			if (getCabEndDateTerms()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralAccessBreach.CollateralAccessBreachBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralAccessBreach.CollateralAccessBreachBuilder o = (CollateralAccessBreach.CollateralAccessBreachBuilder) other;
			
			
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			merger.mergeBasic(getCabEndDateElection(), o.getCabEndDateElection(), this::setCabEndDateElection);
			merger.mergeBasic(getCabEndDate(), o.getCabEndDate(), this::setCabEndDate);
			merger.mergeBasic(getCabEndDateTerms(), o.getCabEndDateTerms(), this::setCabEndDateTerms);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralAccessBreach _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(cabEndDateElection, _that.getCabEndDateElection())) return false;
			if (!Objects.equals(cabEndDate, _that.getCabEndDate())) return false;
			if (!Objects.equals(cabEndDateTerms, _that.getCabEndDateTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (cabEndDateElection != null ? cabEndDateElection.hashCode() : 0);
			_result = 31 * _result + (cabEndDate != null ? cabEndDate.hashCode() : 0);
			_result = 31 * _result + (cabEndDateTerms != null ? cabEndDateTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralAccessBreachBuilder {" +
				"isApplicable=" + this.isApplicable + ", " +
				"cabEndDateElection=" + this.cabEndDateElection + ", " +
				"cabEndDate=" + this.cabEndDate + ", " +
				"cabEndDateTerms=" + this.cabEndDateTerms +
			'}';
		}
	}
}
