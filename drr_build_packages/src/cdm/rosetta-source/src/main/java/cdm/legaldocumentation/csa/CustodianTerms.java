package cdm.legaldocumentation.csa;

import cdm.base.staticdata.party.LegalEntity;
import cdm.legaldocumentation.csa.meta.CustodianTermsMeta;
import cdm.observable.asset.CreditNotation;
import cdm.observable.asset.Money;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the requirements applicable to the custodian with respect to the holding of posted collateral.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Annex CSA_VM_2016 ISDA 2016 Credit Support Annex for Variation Margin  
 * paragraph "13" * clause " (h)(i)" * name "Eligibility to Hold Posted Collateral (VM) Custodians (VM)"
 *
 * Provision 
 *
 */
@RosettaDataType(value="CustodianTerms", builder=CustodianTerms.CustodianTermsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="CustodianTerms", model="cdm", builder=CustodianTerms.CustodianTermsBuilderImpl.class, version="6.23.0")
public interface CustodianTerms extends RosettaModelObject {

	CustodianTermsMeta metaData = new CustodianTermsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The minimal level of assets requirement with respect to the custody agent.
	 */
	Money getMinimumAssets();
	/**
	 * The minimal rating requirement with respect to the custody agent.
	 */
	CreditNotation getMinimumRating();
	/**
	 * Election to specify the initial custodian.
	 *
	 * Body ISDA
	 * Corpus Annex CSA_VM_2016 ISDA 2016 Credit Support Annex for Variation Margin  
	 *
	 * Provision 
	 *
	 */
	LegalEntity getInitialDesignation();

	/*********************** Build Methods  ***********************/
	CustodianTerms build();
	
	CustodianTerms.CustodianTermsBuilder toBuilder();
	
	static CustodianTerms.CustodianTermsBuilder builder() {
		return new CustodianTerms.CustodianTermsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CustodianTerms> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CustodianTerms> getType() {
		return CustodianTerms.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("minimumAssets"), processor, Money.class, getMinimumAssets());
		processRosetta(path.newSubPath("minimumRating"), processor, CreditNotation.class, getMinimumRating());
		processRosetta(path.newSubPath("initialDesignation"), processor, LegalEntity.class, getInitialDesignation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CustodianTermsBuilder extends CustodianTerms, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreateMinimumAssets();
		@Override
		Money.MoneyBuilder getMinimumAssets();
		CreditNotation.CreditNotationBuilder getOrCreateMinimumRating();
		@Override
		CreditNotation.CreditNotationBuilder getMinimumRating();
		LegalEntity.LegalEntityBuilder getOrCreateInitialDesignation();
		@Override
		LegalEntity.LegalEntityBuilder getInitialDesignation();
		CustodianTerms.CustodianTermsBuilder setMinimumAssets(Money minimumAssets);
		CustodianTerms.CustodianTermsBuilder setMinimumRating(CreditNotation minimumRating);
		CustodianTerms.CustodianTermsBuilder setInitialDesignation(LegalEntity initialDesignation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("minimumAssets"), processor, Money.MoneyBuilder.class, getMinimumAssets());
			processRosetta(path.newSubPath("minimumRating"), processor, CreditNotation.CreditNotationBuilder.class, getMinimumRating());
			processRosetta(path.newSubPath("initialDesignation"), processor, LegalEntity.LegalEntityBuilder.class, getInitialDesignation());
		}
		

		CustodianTerms.CustodianTermsBuilder prune();
	}

	/*********************** Immutable Implementation of CustodianTerms  ***********************/
	class CustodianTermsImpl implements CustodianTerms {
		private final Money minimumAssets;
		private final CreditNotation minimumRating;
		private final LegalEntity initialDesignation;
		
		protected CustodianTermsImpl(CustodianTerms.CustodianTermsBuilder builder) {
			this.minimumAssets = ofNullable(builder.getMinimumAssets()).map(f->f.build()).orElse(null);
			this.minimumRating = ofNullable(builder.getMinimumRating()).map(f->f.build()).orElse(null);
			this.initialDesignation = ofNullable(builder.getInitialDesignation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("minimumAssets")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumAssets")
		public Money getMinimumAssets() {
			return minimumAssets;
		}
		
		@Override
		@RosettaAttribute("minimumRating")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumRating")
		public CreditNotation getMinimumRating() {
			return minimumRating;
		}
		
		@Override
		@RosettaAttribute("initialDesignation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialDesignation")
		public LegalEntity getInitialDesignation() {
			return initialDesignation;
		}
		
		@Override
		public CustodianTerms build() {
			return this;
		}
		
		@Override
		public CustodianTerms.CustodianTermsBuilder toBuilder() {
			CustodianTerms.CustodianTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CustodianTerms.CustodianTermsBuilder builder) {
			ofNullable(getMinimumAssets()).ifPresent(builder::setMinimumAssets);
			ofNullable(getMinimumRating()).ifPresent(builder::setMinimumRating);
			ofNullable(getInitialDesignation()).ifPresent(builder::setInitialDesignation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CustodianTerms _that = getType().cast(o);
		
			if (!Objects.equals(minimumAssets, _that.getMinimumAssets())) return false;
			if (!Objects.equals(minimumRating, _that.getMinimumRating())) return false;
			if (!Objects.equals(initialDesignation, _that.getInitialDesignation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (minimumAssets != null ? minimumAssets.hashCode() : 0);
			_result = 31 * _result + (minimumRating != null ? minimumRating.hashCode() : 0);
			_result = 31 * _result + (initialDesignation != null ? initialDesignation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CustodianTerms {" +
				"minimumAssets=" + this.minimumAssets + ", " +
				"minimumRating=" + this.minimumRating + ", " +
				"initialDesignation=" + this.initialDesignation +
			'}';
		}
	}

	/*********************** Builder Implementation of CustodianTerms  ***********************/
	class CustodianTermsBuilderImpl implements CustodianTerms.CustodianTermsBuilder {
	
		protected Money.MoneyBuilder minimumAssets;
		protected CreditNotation.CreditNotationBuilder minimumRating;
		protected LegalEntity.LegalEntityBuilder initialDesignation;
		
		@Override
		@RosettaAttribute("minimumAssets")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumAssets")
		public Money.MoneyBuilder getMinimumAssets() {
			return minimumAssets;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateMinimumAssets() {
			Money.MoneyBuilder result;
			if (minimumAssets!=null) {
				result = minimumAssets;
			}
			else {
				result = minimumAssets = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("minimumRating")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumRating")
		public CreditNotation.CreditNotationBuilder getMinimumRating() {
			return minimumRating;
		}
		
		@Override
		public CreditNotation.CreditNotationBuilder getOrCreateMinimumRating() {
			CreditNotation.CreditNotationBuilder result;
			if (minimumRating!=null) {
				result = minimumRating;
			}
			else {
				result = minimumRating = CreditNotation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("initialDesignation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialDesignation")
		public LegalEntity.LegalEntityBuilder getInitialDesignation() {
			return initialDesignation;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getOrCreateInitialDesignation() {
			LegalEntity.LegalEntityBuilder result;
			if (initialDesignation!=null) {
				result = initialDesignation;
			}
			else {
				result = initialDesignation = LegalEntity.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("minimumAssets")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("minimumAssets")
		@Override
		public CustodianTerms.CustodianTermsBuilder setMinimumAssets(Money _minimumAssets) {
			this.minimumAssets = _minimumAssets == null ? null : _minimumAssets.toBuilder();
			return this;
		}
		
		@RosettaAttribute("minimumRating")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("minimumRating")
		@Override
		public CustodianTerms.CustodianTermsBuilder setMinimumRating(CreditNotation _minimumRating) {
			this.minimumRating = _minimumRating == null ? null : _minimumRating.toBuilder();
			return this;
		}
		
		@RosettaAttribute("initialDesignation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialDesignation")
		@Override
		public CustodianTerms.CustodianTermsBuilder setInitialDesignation(LegalEntity _initialDesignation) {
			this.initialDesignation = _initialDesignation == null ? null : _initialDesignation.toBuilder();
			return this;
		}
		
		@Override
		public CustodianTerms build() {
			return new CustodianTerms.CustodianTermsImpl(this);
		}
		
		@Override
		public CustodianTerms.CustodianTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CustodianTerms.CustodianTermsBuilder prune() {
			if (minimumAssets!=null && !minimumAssets.prune().hasData()) minimumAssets = null;
			if (minimumRating!=null && !minimumRating.prune().hasData()) minimumRating = null;
			if (initialDesignation!=null && !initialDesignation.prune().hasData()) initialDesignation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMinimumAssets()!=null && getMinimumAssets().hasData()) return true;
			if (getMinimumRating()!=null && getMinimumRating().hasData()) return true;
			if (getInitialDesignation()!=null && getInitialDesignation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CustodianTerms.CustodianTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CustodianTerms.CustodianTermsBuilder o = (CustodianTerms.CustodianTermsBuilder) other;
			
			merger.mergeRosetta(getMinimumAssets(), o.getMinimumAssets(), this::setMinimumAssets);
			merger.mergeRosetta(getMinimumRating(), o.getMinimumRating(), this::setMinimumRating);
			merger.mergeRosetta(getInitialDesignation(), o.getInitialDesignation(), this::setInitialDesignation);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CustodianTerms _that = getType().cast(o);
		
			if (!Objects.equals(minimumAssets, _that.getMinimumAssets())) return false;
			if (!Objects.equals(minimumRating, _that.getMinimumRating())) return false;
			if (!Objects.equals(initialDesignation, _that.getInitialDesignation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (minimumAssets != null ? minimumAssets.hashCode() : 0);
			_result = 31 * _result + (minimumRating != null ? minimumRating.hashCode() : 0);
			_result = 31 * _result + (initialDesignation != null ? initialDesignation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CustodianTermsBuilder {" +
				"minimumAssets=" + this.minimumAssets + ", " +
				"minimumRating=" + this.minimumRating + ", " +
				"initialDesignation=" + this.initialDesignation +
			'}';
		}
	}
}
