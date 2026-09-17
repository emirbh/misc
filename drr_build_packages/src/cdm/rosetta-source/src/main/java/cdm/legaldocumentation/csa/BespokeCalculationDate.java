package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.BespokeCalculationDateMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify bespoke Calculation Date terms for the purposes of Initial Margin.
 * @version 6.23.0
 */
@RosettaDataType(value="BespokeCalculationDate", builder=BespokeCalculationDate.BespokeCalculationDateBuilderImpl.class, version="6.23.0")
@RuneDataType(value="BespokeCalculationDate", model="cdm", builder=BespokeCalculationDate.BespokeCalculationDateBuilderImpl.class, version="6.23.0")
public interface BespokeCalculationDate extends RosettaModelObject {

	BespokeCalculationDateMeta metaData = new BespokeCalculationDateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Additional Calculation Date terms are applicable when True and not applicable when False.
	 */
	Boolean getIsApplicable();
	/**
	 * The Additional Calculation Date terms for the purposes of Initial Margin.
	 */
	String getCalculationDateImTerms();

	/*********************** Build Methods  ***********************/
	BespokeCalculationDate build();
	
	BespokeCalculationDate.BespokeCalculationDateBuilder toBuilder();
	
	static BespokeCalculationDate.BespokeCalculationDateBuilder builder() {
		return new BespokeCalculationDate.BespokeCalculationDateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BespokeCalculationDate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BespokeCalculationDate> getType() {
		return BespokeCalculationDate.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
		processor.processBasic(path.newSubPath("calculationDateImTerms"), String.class, getCalculationDateImTerms(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BespokeCalculationDateBuilder extends BespokeCalculationDate, RosettaModelObjectBuilder {
		BespokeCalculationDate.BespokeCalculationDateBuilder setIsApplicable(Boolean isApplicable);
		BespokeCalculationDate.BespokeCalculationDateBuilder setCalculationDateImTerms(String calculationDateImTerms);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
			processor.processBasic(path.newSubPath("calculationDateImTerms"), String.class, getCalculationDateImTerms(), this);
		}
		

		BespokeCalculationDate.BespokeCalculationDateBuilder prune();
	}

	/*********************** Immutable Implementation of BespokeCalculationDate  ***********************/
	class BespokeCalculationDateImpl implements BespokeCalculationDate {
		private final Boolean isApplicable;
		private final String calculationDateImTerms;
		
		protected BespokeCalculationDateImpl(BespokeCalculationDate.BespokeCalculationDateBuilder builder) {
			this.isApplicable = builder.getIsApplicable();
			this.calculationDateImTerms = builder.getCalculationDateImTerms();
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
		@RosettaAttribute("calculationDateImTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationDateImTerms")
		public String getCalculationDateImTerms() {
			return calculationDateImTerms;
		}
		
		@Override
		public BespokeCalculationDate build() {
			return this;
		}
		
		@Override
		public BespokeCalculationDate.BespokeCalculationDateBuilder toBuilder() {
			BespokeCalculationDate.BespokeCalculationDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BespokeCalculationDate.BespokeCalculationDateBuilder builder) {
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
			ofNullable(getCalculationDateImTerms()).ifPresent(builder::setCalculationDateImTerms);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BespokeCalculationDate _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(calculationDateImTerms, _that.getCalculationDateImTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (calculationDateImTerms != null ? calculationDateImTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BespokeCalculationDate {" +
				"isApplicable=" + this.isApplicable + ", " +
				"calculationDateImTerms=" + this.calculationDateImTerms +
			'}';
		}
	}

	/*********************** Builder Implementation of BespokeCalculationDate  ***********************/
	class BespokeCalculationDateBuilderImpl implements BespokeCalculationDate.BespokeCalculationDateBuilder {
	
		protected Boolean isApplicable;
		protected String calculationDateImTerms;
		
		@Override
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isApplicable")
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		@RosettaAttribute("calculationDateImTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationDateImTerms")
		public String getCalculationDateImTerms() {
			return calculationDateImTerms;
		}
		
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("isApplicable")
		@Override
		public BespokeCalculationDate.BespokeCalculationDateBuilder setIsApplicable(Boolean _isApplicable) {
			this.isApplicable = _isApplicable == null ? null : _isApplicable;
			return this;
		}
		
		@RosettaAttribute("calculationDateImTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationDateImTerms")
		@Override
		public BespokeCalculationDate.BespokeCalculationDateBuilder setCalculationDateImTerms(String _calculationDateImTerms) {
			this.calculationDateImTerms = _calculationDateImTerms == null ? null : _calculationDateImTerms;
			return this;
		}
		
		@Override
		public BespokeCalculationDate build() {
			return new BespokeCalculationDate.BespokeCalculationDateImpl(this);
		}
		
		@Override
		public BespokeCalculationDate.BespokeCalculationDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BespokeCalculationDate.BespokeCalculationDateBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIsApplicable()!=null) return true;
			if (getCalculationDateImTerms()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BespokeCalculationDate.BespokeCalculationDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BespokeCalculationDate.BespokeCalculationDateBuilder o = (BespokeCalculationDate.BespokeCalculationDateBuilder) other;
			
			
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			merger.mergeBasic(getCalculationDateImTerms(), o.getCalculationDateImTerms(), this::setCalculationDateImTerms);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BespokeCalculationDate _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(calculationDateImTerms, _that.getCalculationDateImTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (calculationDateImTerms != null ? calculationDateImTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BespokeCalculationDateBuilder {" +
				"isApplicable=" + this.isApplicable + ", " +
				"calculationDateImTerms=" + this.calculationDateImTerms +
			'}';
		}
	}
}
