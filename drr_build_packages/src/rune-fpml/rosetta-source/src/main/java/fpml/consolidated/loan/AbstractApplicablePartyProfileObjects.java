package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.AbstractApplicablePartyProfileObjectsMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision An abstract base type that combines objects applicable to the description of a party profile (e.g. applicable assets and cash events to specific contacts or settlement instructions).
 *
 */
@RosettaDataType(value="AbstractApplicablePartyProfileObjects", builder=AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AbstractApplicablePartyProfileObjects", model="fpml", builder=AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilderImpl.class, version="2.1.1")
public interface AbstractApplicablePartyProfileObjects extends RosettaModelObject {

	AbstractApplicablePartyProfileObjectsMeta metaData = new AbstractApplicablePartyProfileObjectsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	AssociationToAssetIdentifier getIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure which describes the applicable assets.
	 *
	 */
	ApplicableAssets getApplicableAssets();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure that defines specific servicing transactions that a particular payment profile may be associated with.
	 *
	 */
	ApplicableTransactions getApplicableTransactions();

	/*********************** Build Methods  ***********************/
	AbstractApplicablePartyProfileObjects build();
	
	AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder toBuilder();
	
	static AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder builder() {
		return new AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractApplicablePartyProfileObjects> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AbstractApplicablePartyProfileObjects> getType() {
		return AbstractApplicablePartyProfileObjects.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("identifier"), processor, AssociationToAssetIdentifier.class, getIdentifier());
		processRosetta(path.newSubPath("applicableAssets"), processor, ApplicableAssets.class, getApplicableAssets());
		processRosetta(path.newSubPath("applicableTransactions"), processor, ApplicableTransactions.class, getApplicableTransactions());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractApplicablePartyProfileObjectsBuilder extends AbstractApplicablePartyProfileObjects, RosettaModelObjectBuilder {
		AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder getOrCreateIdentifier();
		@Override
		AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder getIdentifier();
		ApplicableAssets.ApplicableAssetsBuilder getOrCreateApplicableAssets();
		@Override
		ApplicableAssets.ApplicableAssetsBuilder getApplicableAssets();
		ApplicableTransactions.ApplicableTransactionsBuilder getOrCreateApplicableTransactions();
		@Override
		ApplicableTransactions.ApplicableTransactionsBuilder getApplicableTransactions();
		AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder setIdentifier(AssociationToAssetIdentifier identifier);
		AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder setApplicableAssets(ApplicableAssets applicableAssets);
		AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder setApplicableTransactions(ApplicableTransactions applicableTransactions);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifier"), processor, AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("applicableAssets"), processor, ApplicableAssets.ApplicableAssetsBuilder.class, getApplicableAssets());
			processRosetta(path.newSubPath("applicableTransactions"), processor, ApplicableTransactions.ApplicableTransactionsBuilder.class, getApplicableTransactions());
		}
		

		AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractApplicablePartyProfileObjects  ***********************/
	class AbstractApplicablePartyProfileObjectsImpl implements AbstractApplicablePartyProfileObjects {
		private final AssociationToAssetIdentifier identifier;
		private final ApplicableAssets applicableAssets;
		private final ApplicableTransactions applicableTransactions;
		
		protected AbstractApplicablePartyProfileObjectsImpl(AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder builder) {
			this.identifier = ofNullable(builder.getIdentifier()).map(f->f.build()).orElse(null);
			this.applicableAssets = ofNullable(builder.getApplicableAssets()).map(f->f.build()).orElse(null);
			this.applicableTransactions = ofNullable(builder.getApplicableTransactions()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("identifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("identifier")
		public AssociationToAssetIdentifier getIdentifier() {
			return identifier;
		}
		
		@Override
		@RosettaAttribute("applicableAssets")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("applicableAssets")
		public ApplicableAssets getApplicableAssets() {
			return applicableAssets;
		}
		
		@Override
		@RosettaAttribute("applicableTransactions")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("applicableTransactions")
		public ApplicableTransactions getApplicableTransactions() {
			return applicableTransactions;
		}
		
		@Override
		public AbstractApplicablePartyProfileObjects build() {
			return this;
		}
		
		@Override
		public AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder toBuilder() {
			AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder builder) {
			ofNullable(getIdentifier()).ifPresent(builder::setIdentifier);
			ofNullable(getApplicableAssets()).ifPresent(builder::setApplicableAssets);
			ofNullable(getApplicableTransactions()).ifPresent(builder::setApplicableTransactions);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbstractApplicablePartyProfileObjects _that = getType().cast(o);
		
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(applicableAssets, _that.getApplicableAssets())) return false;
			if (!Objects.equals(applicableTransactions, _that.getApplicableTransactions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (applicableAssets != null ? applicableAssets.hashCode() : 0);
			_result = 31 * _result + (applicableTransactions != null ? applicableTransactions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractApplicablePartyProfileObjects {" +
				"identifier=" + this.identifier + ", " +
				"applicableAssets=" + this.applicableAssets + ", " +
				"applicableTransactions=" + this.applicableTransactions +
			'}';
		}
	}

	/*********************** Builder Implementation of AbstractApplicablePartyProfileObjects  ***********************/
	class AbstractApplicablePartyProfileObjectsBuilderImpl implements AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder {
	
		protected AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder identifier;
		protected ApplicableAssets.ApplicableAssetsBuilder applicableAssets;
		protected ApplicableTransactions.ApplicableTransactionsBuilder applicableTransactions;
		
		@Override
		@RosettaAttribute("identifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("identifier")
		public AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder getIdentifier() {
			return identifier;
		}
		
		@Override
		public AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder getOrCreateIdentifier() {
			AssociationToAssetIdentifier.AssociationToAssetIdentifierBuilder result;
			if (identifier!=null) {
				result = identifier;
			}
			else {
				result = identifier = AssociationToAssetIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("applicableAssets")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("applicableAssets")
		public ApplicableAssets.ApplicableAssetsBuilder getApplicableAssets() {
			return applicableAssets;
		}
		
		@Override
		public ApplicableAssets.ApplicableAssetsBuilder getOrCreateApplicableAssets() {
			ApplicableAssets.ApplicableAssetsBuilder result;
			if (applicableAssets!=null) {
				result = applicableAssets;
			}
			else {
				result = applicableAssets = ApplicableAssets.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("applicableTransactions")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("applicableTransactions")
		public ApplicableTransactions.ApplicableTransactionsBuilder getApplicableTransactions() {
			return applicableTransactions;
		}
		
		@Override
		public ApplicableTransactions.ApplicableTransactionsBuilder getOrCreateApplicableTransactions() {
			ApplicableTransactions.ApplicableTransactionsBuilder result;
			if (applicableTransactions!=null) {
				result = applicableTransactions;
			}
			else {
				result = applicableTransactions = ApplicableTransactions.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("identifier")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("identifier")
		@Override
		public AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder setIdentifier(AssociationToAssetIdentifier _identifier) {
			this.identifier = _identifier == null ? null : _identifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("applicableAssets")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("applicableAssets")
		@Override
		public AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder setApplicableAssets(ApplicableAssets _applicableAssets) {
			this.applicableAssets = _applicableAssets == null ? null : _applicableAssets.toBuilder();
			return this;
		}
		
		@RosettaAttribute("applicableTransactions")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("applicableTransactions")
		@Override
		public AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder setApplicableTransactions(ApplicableTransactions _applicableTransactions) {
			this.applicableTransactions = _applicableTransactions == null ? null : _applicableTransactions.toBuilder();
			return this;
		}
		
		@Override
		public AbstractApplicablePartyProfileObjects build() {
			return new AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsImpl(this);
		}
		
		@Override
		public AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder prune() {
			if (identifier!=null && !identifier.prune().hasData()) identifier = null;
			if (applicableAssets!=null && !applicableAssets.prune().hasData()) applicableAssets = null;
			if (applicableTransactions!=null && !applicableTransactions.prune().hasData()) applicableTransactions = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIdentifier()!=null && getIdentifier().hasData()) return true;
			if (getApplicableAssets()!=null && getApplicableAssets().hasData()) return true;
			if (getApplicableTransactions()!=null && getApplicableTransactions().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder o = (AbstractApplicablePartyProfileObjects.AbstractApplicablePartyProfileObjectsBuilder) other;
			
			merger.mergeRosetta(getIdentifier(), o.getIdentifier(), this::setIdentifier);
			merger.mergeRosetta(getApplicableAssets(), o.getApplicableAssets(), this::setApplicableAssets);
			merger.mergeRosetta(getApplicableTransactions(), o.getApplicableTransactions(), this::setApplicableTransactions);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbstractApplicablePartyProfileObjects _that = getType().cast(o);
		
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(applicableAssets, _that.getApplicableAssets())) return false;
			if (!Objects.equals(applicableTransactions, _that.getApplicableTransactions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (applicableAssets != null ? applicableAssets.hashCode() : 0);
			_result = 31 * _result + (applicableTransactions != null ? applicableTransactions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractApplicablePartyProfileObjectsBuilder {" +
				"identifier=" + this.identifier + ", " +
				"applicableAssets=" + this.applicableAssets + ", " +
				"applicableTransactions=" + this.applicableTransactions +
			'}';
		}
	}
}
