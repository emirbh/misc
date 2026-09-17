package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.SubstitutionMeta;
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
 * A class to specify the conditions under which the Security Provider can substitute posted collateral. The details required for &#39;Legacy&#39; agreements are substantially different to those required for newer agreements; where the agreement is a 1994 or 1995 CSA, or 1995 CSD, the legacyConsent attribute needs to be used which contains additional values beyond a simple true/false value.
 * @version 6.23.0
 */
@RosettaDataType(value="Substitution", builder=Substitution.SubstitutionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="Substitution", model="cdm", builder=Substitution.SubstitutionBuilderImpl.class, version="6.23.0")
public interface Substitution extends RosettaModelObject {

	SubstitutionMeta metaData = new SubstitutionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The election as to whether the Pledgor/Obligor/Chargor must obtain the Secured Partys consent for any collateral substitution.
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_2016 ISDA 2016 Credit Support Annex for Initial Margin  
	 * paragraph "13 General Principles" * clause "(f)(ii)" * name "Consent"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Annex CSA_VM_2016 ISDA 2016 Credit Support Annex for Variation Margin  
	 * paragraph "13" * clause "(f)(ii)" * name "Consent"
	 *
	 * Provision 
	 *
	 */
	Boolean getNeedsConsent();
	/**
	 * Substitution Date has the meaning specified in Paragraph4(d)(ii), unless otherwise specified.
	 */
	String getSubstitutionDateLanguage();
	/**
	 * Specific consent language might be specified by the parties.
	 */
	String getSpecificConsentLanguage();
	/**
	 * The process for substituting/exchanging one form of collateral held by a party for a different form of collateral, used with legacy agreements.
	 */
	LegacyConsentEnum getLegacyConsent();

	/*********************** Build Methods  ***********************/
	Substitution build();
	
	Substitution.SubstitutionBuilder toBuilder();
	
	static Substitution.SubstitutionBuilder builder() {
		return new Substitution.SubstitutionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Substitution> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Substitution> getType() {
		return Substitution.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("needsConsent"), Boolean.class, getNeedsConsent(), this);
		processor.processBasic(path.newSubPath("substitutionDateLanguage"), String.class, getSubstitutionDateLanguage(), this);
		processor.processBasic(path.newSubPath("specificConsentLanguage"), String.class, getSpecificConsentLanguage(), this);
		processor.processBasic(path.newSubPath("legacyConsent"), LegacyConsentEnum.class, getLegacyConsent(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SubstitutionBuilder extends Substitution, RosettaModelObjectBuilder {
		Substitution.SubstitutionBuilder setNeedsConsent(Boolean needsConsent);
		Substitution.SubstitutionBuilder setSubstitutionDateLanguage(String substitutionDateLanguage);
		Substitution.SubstitutionBuilder setSpecificConsentLanguage(String specificConsentLanguage);
		Substitution.SubstitutionBuilder setLegacyConsent(LegacyConsentEnum legacyConsent);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("needsConsent"), Boolean.class, getNeedsConsent(), this);
			processor.processBasic(path.newSubPath("substitutionDateLanguage"), String.class, getSubstitutionDateLanguage(), this);
			processor.processBasic(path.newSubPath("specificConsentLanguage"), String.class, getSpecificConsentLanguage(), this);
			processor.processBasic(path.newSubPath("legacyConsent"), LegacyConsentEnum.class, getLegacyConsent(), this);
		}
		

		Substitution.SubstitutionBuilder prune();
	}

	/*********************** Immutable Implementation of Substitution  ***********************/
	class SubstitutionImpl implements Substitution {
		private final Boolean needsConsent;
		private final String substitutionDateLanguage;
		private final String specificConsentLanguage;
		private final LegacyConsentEnum legacyConsent;
		
		protected SubstitutionImpl(Substitution.SubstitutionBuilder builder) {
			this.needsConsent = builder.getNeedsConsent();
			this.substitutionDateLanguage = builder.getSubstitutionDateLanguage();
			this.specificConsentLanguage = builder.getSpecificConsentLanguage();
			this.legacyConsent = builder.getLegacyConsent();
		}
		
		@Override
		@RosettaAttribute("needsConsent")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("needsConsent")
		public Boolean getNeedsConsent() {
			return needsConsent;
		}
		
		@Override
		@RosettaAttribute("substitutionDateLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("substitutionDateLanguage")
		public String getSubstitutionDateLanguage() {
			return substitutionDateLanguage;
		}
		
		@Override
		@RosettaAttribute("specificConsentLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("specificConsentLanguage")
		public String getSpecificConsentLanguage() {
			return specificConsentLanguage;
		}
		
		@Override
		@RosettaAttribute("legacyConsent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legacyConsent")
		public LegacyConsentEnum getLegacyConsent() {
			return legacyConsent;
		}
		
		@Override
		public Substitution build() {
			return this;
		}
		
		@Override
		public Substitution.SubstitutionBuilder toBuilder() {
			Substitution.SubstitutionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Substitution.SubstitutionBuilder builder) {
			ofNullable(getNeedsConsent()).ifPresent(builder::setNeedsConsent);
			ofNullable(getSubstitutionDateLanguage()).ifPresent(builder::setSubstitutionDateLanguage);
			ofNullable(getSpecificConsentLanguage()).ifPresent(builder::setSpecificConsentLanguage);
			ofNullable(getLegacyConsent()).ifPresent(builder::setLegacyConsent);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Substitution _that = getType().cast(o);
		
			if (!Objects.equals(needsConsent, _that.getNeedsConsent())) return false;
			if (!Objects.equals(substitutionDateLanguage, _that.getSubstitutionDateLanguage())) return false;
			if (!Objects.equals(specificConsentLanguage, _that.getSpecificConsentLanguage())) return false;
			if (!Objects.equals(legacyConsent, _that.getLegacyConsent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (needsConsent != null ? needsConsent.hashCode() : 0);
			_result = 31 * _result + (substitutionDateLanguage != null ? substitutionDateLanguage.hashCode() : 0);
			_result = 31 * _result + (specificConsentLanguage != null ? specificConsentLanguage.hashCode() : 0);
			_result = 31 * _result + (legacyConsent != null ? legacyConsent.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Substitution {" +
				"needsConsent=" + this.needsConsent + ", " +
				"substitutionDateLanguage=" + this.substitutionDateLanguage + ", " +
				"specificConsentLanguage=" + this.specificConsentLanguage + ", " +
				"legacyConsent=" + this.legacyConsent +
			'}';
		}
	}

	/*********************** Builder Implementation of Substitution  ***********************/
	class SubstitutionBuilderImpl implements Substitution.SubstitutionBuilder {
	
		protected Boolean needsConsent;
		protected String substitutionDateLanguage;
		protected String specificConsentLanguage;
		protected LegacyConsentEnum legacyConsent;
		
		@Override
		@RosettaAttribute("needsConsent")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("needsConsent")
		public Boolean getNeedsConsent() {
			return needsConsent;
		}
		
		@Override
		@RosettaAttribute("substitutionDateLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("substitutionDateLanguage")
		public String getSubstitutionDateLanguage() {
			return substitutionDateLanguage;
		}
		
		@Override
		@RosettaAttribute("specificConsentLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("specificConsentLanguage")
		public String getSpecificConsentLanguage() {
			return specificConsentLanguage;
		}
		
		@Override
		@RosettaAttribute("legacyConsent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legacyConsent")
		public LegacyConsentEnum getLegacyConsent() {
			return legacyConsent;
		}
		
		@RosettaAttribute("needsConsent")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("needsConsent")
		@Override
		public Substitution.SubstitutionBuilder setNeedsConsent(Boolean _needsConsent) {
			this.needsConsent = _needsConsent == null ? null : _needsConsent;
			return this;
		}
		
		@RosettaAttribute("substitutionDateLanguage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("substitutionDateLanguage")
		@Override
		public Substitution.SubstitutionBuilder setSubstitutionDateLanguage(String _substitutionDateLanguage) {
			this.substitutionDateLanguage = _substitutionDateLanguage == null ? null : _substitutionDateLanguage;
			return this;
		}
		
		@RosettaAttribute("specificConsentLanguage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("specificConsentLanguage")
		@Override
		public Substitution.SubstitutionBuilder setSpecificConsentLanguage(String _specificConsentLanguage) {
			this.specificConsentLanguage = _specificConsentLanguage == null ? null : _specificConsentLanguage;
			return this;
		}
		
		@RosettaAttribute("legacyConsent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legacyConsent")
		@Override
		public Substitution.SubstitutionBuilder setLegacyConsent(LegacyConsentEnum _legacyConsent) {
			this.legacyConsent = _legacyConsent == null ? null : _legacyConsent;
			return this;
		}
		
		@Override
		public Substitution build() {
			return new Substitution.SubstitutionImpl(this);
		}
		
		@Override
		public Substitution.SubstitutionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Substitution.SubstitutionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNeedsConsent()!=null) return true;
			if (getSubstitutionDateLanguage()!=null) return true;
			if (getSpecificConsentLanguage()!=null) return true;
			if (getLegacyConsent()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Substitution.SubstitutionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Substitution.SubstitutionBuilder o = (Substitution.SubstitutionBuilder) other;
			
			
			merger.mergeBasic(getNeedsConsent(), o.getNeedsConsent(), this::setNeedsConsent);
			merger.mergeBasic(getSubstitutionDateLanguage(), o.getSubstitutionDateLanguage(), this::setSubstitutionDateLanguage);
			merger.mergeBasic(getSpecificConsentLanguage(), o.getSpecificConsentLanguage(), this::setSpecificConsentLanguage);
			merger.mergeBasic(getLegacyConsent(), o.getLegacyConsent(), this::setLegacyConsent);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Substitution _that = getType().cast(o);
		
			if (!Objects.equals(needsConsent, _that.getNeedsConsent())) return false;
			if (!Objects.equals(substitutionDateLanguage, _that.getSubstitutionDateLanguage())) return false;
			if (!Objects.equals(specificConsentLanguage, _that.getSpecificConsentLanguage())) return false;
			if (!Objects.equals(legacyConsent, _that.getLegacyConsent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (needsConsent != null ? needsConsent.hashCode() : 0);
			_result = 31 * _result + (substitutionDateLanguage != null ? substitutionDateLanguage.hashCode() : 0);
			_result = 31 * _result + (specificConsentLanguage != null ? specificConsentLanguage.hashCode() : 0);
			_result = 31 * _result + (legacyConsent != null ? legacyConsent.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SubstitutionBuilder {" +
				"needsConsent=" + this.needsConsent + ", " +
				"substitutionDateLanguage=" + this.substitutionDateLanguage + ", " +
				"specificConsentLanguage=" + this.specificConsentLanguage + ", " +
				"legacyConsent=" + this.legacyConsent +
			'}';
		}
	}
}
