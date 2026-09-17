package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.ConditionsPrecedentMeta;
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
 * A class to specify the two set of elections that may overwrite the default Condition Precedent provision.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Annex CSA_IM_2016 ISDA 2016 Credit Support Annex for Initial Margin  
 * paragraph "4" * clause "(a)"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_VM_2016 ISDA 2016 Credit Support Annex for Variation Margin  
 * paragraph "4" * clause "(a)"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Deed CSD_IM_English_2016 ISDA 2016 English Law Credit Support Deed for Initial Margin  
 * paragraph "13 General Principles" * clause "(e)" * name " Conditions Precedent"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Deed CSD_IM_English_2018 ISDA 2018 English Law Credit Support Deed for Initial Margin  
 * paragraph "13 General Principles" * clause "(e)" * name " Conditions Precedent"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_IM_Japanese_2016 ISDA 2016 Japanese Law Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(f)" * name " Conditions Precedent"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_IM_NewYork_2016 ISDA 2016 New York Law Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(e)" * name " Conditions Precedent"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_VM_2016 ISDA 2016 Credit Support Annex for Variation Margin  
 * paragraph "13" * clause "(e)" * name "Conditions Precedent and Secured Partys Rights and Remedies"
 *
 * Provision 
 *
 */
@RosettaDataType(value="ConditionsPrecedent", builder=ConditionsPrecedent.ConditionsPrecedentBuilderImpl.class, version="6.23.0")
@RuneDataType(value="ConditionsPrecedent", model="cdm", builder=ConditionsPrecedent.ConditionsPrecedentBuilderImpl.class, version="6.23.0")
public interface ConditionsPrecedent extends RosettaModelObject {

	ConditionsPrecedentMeta metaData = new ConditionsPrecedentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The election to specify whether the standard Conditions Precedent apply.
	 */
	ExceptionEnum getConditionsPrecedentElection();
	/**
	 * The custom provisions that might be specified by the parties to the agreement for the purpose of overwriting the default Condition Precedent provision specified in the CSA.
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_2016 ISDA 2016 Credit Support Annex for Initial Margin  
	 * paragraph "4" * clause "(a)"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Annex CSA_VM_2016 ISDA 2016 Credit Support Annex for Variation Margin  
	 * paragraph "4" * clause "(a)"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Deed CSD_IM_English_2016 ISDA 2016 English Law Credit Support Deed for Initial Margin  
	 * paragraph "13 General Principles" * clause "(e)(i)"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_Japanese_2016 ISDA 2016 Japanese Law Credit Support Annex for Initial Margin  
	 * paragraph "13 General Principles" * clause "(f)(i)"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_NewYork_2016 ISDA 2016 New York Law Credit Support Annex for Initial Margin  
	 * paragraph "13 General Principles" * clause "(e)(i)"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Annex CSA_VM_2016 ISDA 2016 Credit Support Annex for Variation Margin  
	 * paragraph "13" * name "Conditions Precedent and Secured Partys Rights and Remedies"
	 *
	 * Provision 
	 *
	 */
	String getCustomProvision();
	/**
	 * The parties&#39; election with respect to the Termination Events that will be deemed an Access Condition (Initial Margin CSA) or a Specified Condition (Variation Margin CSA).
	 *
	 * Body ISDA
	 * Corpus Deed CSD_IM_English_2016 ISDA 2016 English Law Credit Support Deed for Initial Margin  
	 * paragraph "13 General Principles" * clause "(e)(ii)"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_Japanese_2016 ISDA 2016 Japanese Law Credit Support Annex for Initial Margin  
	 * paragraph "13 General Principles" * clause "(f)(ii)"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_NewYork_2016 ISDA 2016 New York Law Credit Support Annex for Initial Margin  
	 * paragraph "13 General Principles" * clause "(e)(ii)"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Annex CSA_VM_2016 ISDA 2016 Credit Support Annex for Variation Margin  
	 * paragraph "13" * clause "(e)" * name "Conditions Precedent and Secured Partys Rights and Remedies."
	 *
	 * Provision 
	 *
	 */
	AccessConditions getAccessConditions();

	/*********************** Build Methods  ***********************/
	ConditionsPrecedent build();
	
	ConditionsPrecedent.ConditionsPrecedentBuilder toBuilder();
	
	static ConditionsPrecedent.ConditionsPrecedentBuilder builder() {
		return new ConditionsPrecedent.ConditionsPrecedentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ConditionsPrecedent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ConditionsPrecedent> getType() {
		return ConditionsPrecedent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("conditionsPrecedentElection"), ExceptionEnum.class, getConditionsPrecedentElection(), this);
		processor.processBasic(path.newSubPath("customProvision"), String.class, getCustomProvision(), this);
		processRosetta(path.newSubPath("accessConditions"), processor, AccessConditions.class, getAccessConditions());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ConditionsPrecedentBuilder extends ConditionsPrecedent, RosettaModelObjectBuilder {
		AccessConditions.AccessConditionsBuilder getOrCreateAccessConditions();
		@Override
		AccessConditions.AccessConditionsBuilder getAccessConditions();
		ConditionsPrecedent.ConditionsPrecedentBuilder setConditionsPrecedentElection(ExceptionEnum conditionsPrecedentElection);
		ConditionsPrecedent.ConditionsPrecedentBuilder setCustomProvision(String customProvision);
		ConditionsPrecedent.ConditionsPrecedentBuilder setAccessConditions(AccessConditions accessConditions);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("conditionsPrecedentElection"), ExceptionEnum.class, getConditionsPrecedentElection(), this);
			processor.processBasic(path.newSubPath("customProvision"), String.class, getCustomProvision(), this);
			processRosetta(path.newSubPath("accessConditions"), processor, AccessConditions.AccessConditionsBuilder.class, getAccessConditions());
		}
		

		ConditionsPrecedent.ConditionsPrecedentBuilder prune();
	}

	/*********************** Immutable Implementation of ConditionsPrecedent  ***********************/
	class ConditionsPrecedentImpl implements ConditionsPrecedent {
		private final ExceptionEnum conditionsPrecedentElection;
		private final String customProvision;
		private final AccessConditions accessConditions;
		
		protected ConditionsPrecedentImpl(ConditionsPrecedent.ConditionsPrecedentBuilder builder) {
			this.conditionsPrecedentElection = builder.getConditionsPrecedentElection();
			this.customProvision = builder.getCustomProvision();
			this.accessConditions = ofNullable(builder.getAccessConditions()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("conditionsPrecedentElection")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("conditionsPrecedentElection")
		public ExceptionEnum getConditionsPrecedentElection() {
			return conditionsPrecedentElection;
		}
		
		@Override
		@RosettaAttribute("customProvision")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("customProvision")
		public String getCustomProvision() {
			return customProvision;
		}
		
		@Override
		@RosettaAttribute("accessConditions")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("accessConditions")
		public AccessConditions getAccessConditions() {
			return accessConditions;
		}
		
		@Override
		public ConditionsPrecedent build() {
			return this;
		}
		
		@Override
		public ConditionsPrecedent.ConditionsPrecedentBuilder toBuilder() {
			ConditionsPrecedent.ConditionsPrecedentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ConditionsPrecedent.ConditionsPrecedentBuilder builder) {
			ofNullable(getConditionsPrecedentElection()).ifPresent(builder::setConditionsPrecedentElection);
			ofNullable(getCustomProvision()).ifPresent(builder::setCustomProvision);
			ofNullable(getAccessConditions()).ifPresent(builder::setAccessConditions);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ConditionsPrecedent _that = getType().cast(o);
		
			if (!Objects.equals(conditionsPrecedentElection, _that.getConditionsPrecedentElection())) return false;
			if (!Objects.equals(customProvision, _that.getCustomProvision())) return false;
			if (!Objects.equals(accessConditions, _that.getAccessConditions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (conditionsPrecedentElection != null ? conditionsPrecedentElection.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (customProvision != null ? customProvision.hashCode() : 0);
			_result = 31 * _result + (accessConditions != null ? accessConditions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ConditionsPrecedent {" +
				"conditionsPrecedentElection=" + this.conditionsPrecedentElection + ", " +
				"customProvision=" + this.customProvision + ", " +
				"accessConditions=" + this.accessConditions +
			'}';
		}
	}

	/*********************** Builder Implementation of ConditionsPrecedent  ***********************/
	class ConditionsPrecedentBuilderImpl implements ConditionsPrecedent.ConditionsPrecedentBuilder {
	
		protected ExceptionEnum conditionsPrecedentElection;
		protected String customProvision;
		protected AccessConditions.AccessConditionsBuilder accessConditions;
		
		@Override
		@RosettaAttribute("conditionsPrecedentElection")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("conditionsPrecedentElection")
		public ExceptionEnum getConditionsPrecedentElection() {
			return conditionsPrecedentElection;
		}
		
		@Override
		@RosettaAttribute("customProvision")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("customProvision")
		public String getCustomProvision() {
			return customProvision;
		}
		
		@Override
		@RosettaAttribute("accessConditions")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("accessConditions")
		public AccessConditions.AccessConditionsBuilder getAccessConditions() {
			return accessConditions;
		}
		
		@Override
		public AccessConditions.AccessConditionsBuilder getOrCreateAccessConditions() {
			AccessConditions.AccessConditionsBuilder result;
			if (accessConditions!=null) {
				result = accessConditions;
			}
			else {
				result = accessConditions = AccessConditions.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("conditionsPrecedentElection")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("conditionsPrecedentElection")
		@Override
		public ConditionsPrecedent.ConditionsPrecedentBuilder setConditionsPrecedentElection(ExceptionEnum _conditionsPrecedentElection) {
			this.conditionsPrecedentElection = _conditionsPrecedentElection == null ? null : _conditionsPrecedentElection;
			return this;
		}
		
		@RosettaAttribute("customProvision")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("customProvision")
		@Override
		public ConditionsPrecedent.ConditionsPrecedentBuilder setCustomProvision(String _customProvision) {
			this.customProvision = _customProvision == null ? null : _customProvision;
			return this;
		}
		
		@RosettaAttribute("accessConditions")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("accessConditions")
		@Override
		public ConditionsPrecedent.ConditionsPrecedentBuilder setAccessConditions(AccessConditions _accessConditions) {
			this.accessConditions = _accessConditions == null ? null : _accessConditions.toBuilder();
			return this;
		}
		
		@Override
		public ConditionsPrecedent build() {
			return new ConditionsPrecedent.ConditionsPrecedentImpl(this);
		}
		
		@Override
		public ConditionsPrecedent.ConditionsPrecedentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConditionsPrecedent.ConditionsPrecedentBuilder prune() {
			if (accessConditions!=null && !accessConditions.prune().hasData()) accessConditions = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getConditionsPrecedentElection()!=null) return true;
			if (getCustomProvision()!=null) return true;
			if (getAccessConditions()!=null && getAccessConditions().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConditionsPrecedent.ConditionsPrecedentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ConditionsPrecedent.ConditionsPrecedentBuilder o = (ConditionsPrecedent.ConditionsPrecedentBuilder) other;
			
			merger.mergeRosetta(getAccessConditions(), o.getAccessConditions(), this::setAccessConditions);
			
			merger.mergeBasic(getConditionsPrecedentElection(), o.getConditionsPrecedentElection(), this::setConditionsPrecedentElection);
			merger.mergeBasic(getCustomProvision(), o.getCustomProvision(), this::setCustomProvision);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ConditionsPrecedent _that = getType().cast(o);
		
			if (!Objects.equals(conditionsPrecedentElection, _that.getConditionsPrecedentElection())) return false;
			if (!Objects.equals(customProvision, _that.getCustomProvision())) return false;
			if (!Objects.equals(accessConditions, _that.getAccessConditions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (conditionsPrecedentElection != null ? conditionsPrecedentElection.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (customProvision != null ? customProvision.hashCode() : 0);
			_result = 31 * _result + (accessConditions != null ? accessConditions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ConditionsPrecedentBuilder {" +
				"conditionsPrecedentElection=" + this.conditionsPrecedentElection + ", " +
				"customProvision=" + this.customProvision + ", " +
				"accessConditions=" + this.accessConditions +
			'}';
		}
	}
}
