package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.AppropriatedCollateralValuationMeta;
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
 * A class to specify the Valuation of Appropriated Collateral.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Deed CSD_IM_English_2016 ISDA 2016 English Law Credit Support Deed for Initial Margin  
 * paragraph "13 General Principles" * clause "(u)" * name "Valuation of Appropriated Collateral"
 *
 * Provision 
 *
 */
@RosettaDataType(value="AppropriatedCollateralValuation", builder=AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilderImpl.class, version="6.23.0")
@RuneDataType(value="AppropriatedCollateralValuation", model="cdm", builder=AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilderImpl.class, version="6.23.0")
public interface AppropriatedCollateralValuation extends RosettaModelObject {

	AppropriatedCollateralValuationMeta metaData = new AppropriatedCollateralValuationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The qualification of whether the Valuation of Appropriate Collateral provision is applicable (True) or not applicable (False).
	 */
	Boolean getIsSpecified();
	/**
	 * The parties&#39; election that qualify the Valuation of Appropriate Collateral in the case where it is deemed applicable.
	 */
	String getElection();

	/*********************** Build Methods  ***********************/
	AppropriatedCollateralValuation build();
	
	AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder toBuilder();
	
	static AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder builder() {
		return new AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AppropriatedCollateralValuation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AppropriatedCollateralValuation> getType() {
		return AppropriatedCollateralValuation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isSpecified"), Boolean.class, getIsSpecified(), this);
		processor.processBasic(path.newSubPath("election"), String.class, getElection(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AppropriatedCollateralValuationBuilder extends AppropriatedCollateralValuation, RosettaModelObjectBuilder {
		AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder setIsSpecified(Boolean isSpecified);
		AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder setElection(String election);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("isSpecified"), Boolean.class, getIsSpecified(), this);
			processor.processBasic(path.newSubPath("election"), String.class, getElection(), this);
		}
		

		AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder prune();
	}

	/*********************** Immutable Implementation of AppropriatedCollateralValuation  ***********************/
	class AppropriatedCollateralValuationImpl implements AppropriatedCollateralValuation {
		private final Boolean isSpecified;
		private final String election;
		
		protected AppropriatedCollateralValuationImpl(AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder builder) {
			this.isSpecified = builder.getIsSpecified();
			this.election = builder.getElection();
		}
		
		@Override
		@RosettaAttribute("isSpecified")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isSpecified")
		public Boolean getIsSpecified() {
			return isSpecified;
		}
		
		@Override
		@RosettaAttribute("election")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("election")
		public String getElection() {
			return election;
		}
		
		@Override
		public AppropriatedCollateralValuation build() {
			return this;
		}
		
		@Override
		public AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder toBuilder() {
			AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder builder) {
			ofNullable(getIsSpecified()).ifPresent(builder::setIsSpecified);
			ofNullable(getElection()).ifPresent(builder::setElection);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AppropriatedCollateralValuation _that = getType().cast(o);
		
			if (!Objects.equals(isSpecified, _that.getIsSpecified())) return false;
			if (!Objects.equals(election, _that.getElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isSpecified != null ? isSpecified.hashCode() : 0);
			_result = 31 * _result + (election != null ? election.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AppropriatedCollateralValuation {" +
				"isSpecified=" + this.isSpecified + ", " +
				"election=" + this.election +
			'}';
		}
	}

	/*********************** Builder Implementation of AppropriatedCollateralValuation  ***********************/
	class AppropriatedCollateralValuationBuilderImpl implements AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder {
	
		protected Boolean isSpecified;
		protected String election;
		
		@Override
		@RosettaAttribute("isSpecified")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isSpecified")
		public Boolean getIsSpecified() {
			return isSpecified;
		}
		
		@Override
		@RosettaAttribute("election")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("election")
		public String getElection() {
			return election;
		}
		
		@RosettaAttribute("isSpecified")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("isSpecified")
		@Override
		public AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder setIsSpecified(Boolean _isSpecified) {
			this.isSpecified = _isSpecified == null ? null : _isSpecified;
			return this;
		}
		
		@RosettaAttribute("election")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("election")
		@Override
		public AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder setElection(String _election) {
			this.election = _election == null ? null : _election;
			return this;
		}
		
		@Override
		public AppropriatedCollateralValuation build() {
			return new AppropriatedCollateralValuation.AppropriatedCollateralValuationImpl(this);
		}
		
		@Override
		public AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIsSpecified()!=null) return true;
			if (getElection()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder o = (AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder) other;
			
			
			merger.mergeBasic(getIsSpecified(), o.getIsSpecified(), this::setIsSpecified);
			merger.mergeBasic(getElection(), o.getElection(), this::setElection);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AppropriatedCollateralValuation _that = getType().cast(o);
		
			if (!Objects.equals(isSpecified, _that.getIsSpecified())) return false;
			if (!Objects.equals(election, _that.getElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isSpecified != null ? isSpecified.hashCode() : 0);
			_result = 31 * _result + (election != null ? election.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AppropriatedCollateralValuationBuilder {" +
				"isSpecified=" + this.isSpecified + ", " +
				"election=" + this.election +
			'}';
		}
	}
}
