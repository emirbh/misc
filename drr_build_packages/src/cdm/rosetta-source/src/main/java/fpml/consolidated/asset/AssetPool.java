package fpml.consolidated.asset;

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
import fpml.consolidated.asset.meta.AssetPoolMeta;
import fpml.consolidated.shared.IdentifiedDate;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Characterise the asset pool behind an asset backed bond.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Characterise the asset pool behind an asset backed bond.
 *
 */
@RosettaDataType(value="AssetPool", builder=AssetPool.AssetPoolBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AssetPool", model="fpml", builder=AssetPool.AssetPoolBuilderImpl.class, version="2.1.1")
public interface AssetPool extends RosettaModelObject {

	AssetPoolMeta metaData = new AssetPoolMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The version number
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The version number
	 *
	 */
	Integer getVersion();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Optionally it is possible to specify a version effective date when a versionId is supplied.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Optionally it is possible to specify a version effective date when a versionId is supplied.
	 *
	 */
	IdentifiedDate getEffectiveDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The part of the mortgage that is outstanding on trade inception, i.e. has not been repaid yet as principal. It is expressed as a multiplier factor to the morgage: 1 means that the whole mortage amount is outstanding, 0.8 means that 20% has been repaid.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The part of the mortgage that is outstanding on trade inception, i.e. has not been repaid yet as principal. It is expressed as a multiplier factor to the morgage: 1 means that the whole mortage amount is outstanding, 0.8 means that 20% has been repaid.
	 *
	 */
	BigDecimal getInitialFactor();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The part of the mortgage that is currently outstanding. It is expressed similarly to the initial factor, as factor multiplier to the mortgage. This term is formally defined as part of the "ISDA Standard Terms Supplement for use with credit derivatives transactions on mortgage-backed security with pas-as-you-go or physical settlement".
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The part of the mortgage that is currently outstanding. It is expressed similarly to the initial factor, as factor multiplier to the mortgage. This term is formally defined as part of the "ISDA Standard Terms Supplement for use with credit derivatives transactions on mortgage-backed security with pas-as-you-go or physical settlement".
	 *
	 */
	BigDecimal getCurrentFactor();

	/*********************** Build Methods  ***********************/
	AssetPool build();
	
	AssetPool.AssetPoolBuilder toBuilder();
	
	static AssetPool.AssetPoolBuilder builder() {
		return new AssetPool.AssetPoolBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetPool> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetPool> getType() {
		return AssetPool.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("version"), Integer.class, getVersion(), this);
		processRosetta(path.newSubPath("effectiveDate"), processor, IdentifiedDate.class, getEffectiveDate());
		processor.processBasic(path.newSubPath("initialFactor"), BigDecimal.class, getInitialFactor(), this);
		processor.processBasic(path.newSubPath("currentFactor"), BigDecimal.class, getCurrentFactor(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetPoolBuilder extends AssetPool, RosettaModelObjectBuilder {
		IdentifiedDate.IdentifiedDateBuilder getOrCreateEffectiveDate();
		@Override
		IdentifiedDate.IdentifiedDateBuilder getEffectiveDate();
		AssetPool.AssetPoolBuilder setVersion(Integer version);
		AssetPool.AssetPoolBuilder setEffectiveDate(IdentifiedDate effectiveDate);
		AssetPool.AssetPoolBuilder setInitialFactor(BigDecimal initialFactor);
		AssetPool.AssetPoolBuilder setCurrentFactor(BigDecimal currentFactor);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("version"), Integer.class, getVersion(), this);
			processRosetta(path.newSubPath("effectiveDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getEffectiveDate());
			processor.processBasic(path.newSubPath("initialFactor"), BigDecimal.class, getInitialFactor(), this);
			processor.processBasic(path.newSubPath("currentFactor"), BigDecimal.class, getCurrentFactor(), this);
		}
		

		AssetPool.AssetPoolBuilder prune();
	}

	/*********************** Immutable Implementation of AssetPool  ***********************/
	class AssetPoolImpl implements AssetPool {
		private final Integer version;
		private final IdentifiedDate effectiveDate;
		private final BigDecimal initialFactor;
		private final BigDecimal currentFactor;
		
		protected AssetPoolImpl(AssetPool.AssetPoolBuilder builder) {
			this.version = builder.getVersion();
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
			this.initialFactor = builder.getInitialFactor();
			this.currentFactor = builder.getCurrentFactor();
		}
		
		@Override
		@RosettaAttribute("version")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("version")
		public Integer getVersion() {
			return version;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("effectiveDate")
		public IdentifiedDate getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("initialFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialFactor")
		public BigDecimal getInitialFactor() {
			return initialFactor;
		}
		
		@Override
		@RosettaAttribute("currentFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currentFactor")
		public BigDecimal getCurrentFactor() {
			return currentFactor;
		}
		
		@Override
		public AssetPool build() {
			return this;
		}
		
		@Override
		public AssetPool.AssetPoolBuilder toBuilder() {
			AssetPool.AssetPoolBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetPool.AssetPoolBuilder builder) {
			ofNullable(getVersion()).ifPresent(builder::setVersion);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getInitialFactor()).ifPresent(builder::setInitialFactor);
			ofNullable(getCurrentFactor()).ifPresent(builder::setCurrentFactor);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetPool _that = getType().cast(o);
		
			if (!Objects.equals(version, _that.getVersion())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(initialFactor, _that.getInitialFactor())) return false;
			if (!Objects.equals(currentFactor, _that.getCurrentFactor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (initialFactor != null ? initialFactor.hashCode() : 0);
			_result = 31 * _result + (currentFactor != null ? currentFactor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetPool {" +
				"version=" + this.version + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"initialFactor=" + this.initialFactor + ", " +
				"currentFactor=" + this.currentFactor +
			'}';
		}
	}

	/*********************** Builder Implementation of AssetPool  ***********************/
	class AssetPoolBuilderImpl implements AssetPool.AssetPoolBuilder {
	
		protected Integer version;
		protected IdentifiedDate.IdentifiedDateBuilder effectiveDate;
		protected BigDecimal initialFactor;
		protected BigDecimal currentFactor;
		
		@Override
		@RosettaAttribute("version")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("version")
		public Integer getVersion() {
			return version;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("effectiveDate")
		public IdentifiedDate.IdentifiedDateBuilder getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateEffectiveDate() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (effectiveDate!=null) {
				result = effectiveDate;
			}
			else {
				result = effectiveDate = IdentifiedDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("initialFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialFactor")
		public BigDecimal getInitialFactor() {
			return initialFactor;
		}
		
		@Override
		@RosettaAttribute("currentFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currentFactor")
		public BigDecimal getCurrentFactor() {
			return currentFactor;
		}
		
		@RosettaAttribute("version")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("version")
		@Override
		public AssetPool.AssetPoolBuilder setVersion(Integer _version) {
			this.version = _version == null ? null : _version;
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public AssetPool.AssetPoolBuilder setEffectiveDate(IdentifiedDate _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("initialFactor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialFactor")
		@Override
		public AssetPool.AssetPoolBuilder setInitialFactor(BigDecimal _initialFactor) {
			this.initialFactor = _initialFactor == null ? null : _initialFactor;
			return this;
		}
		
		@RosettaAttribute("currentFactor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currentFactor")
		@Override
		public AssetPool.AssetPoolBuilder setCurrentFactor(BigDecimal _currentFactor) {
			this.currentFactor = _currentFactor == null ? null : _currentFactor;
			return this;
		}
		
		@Override
		public AssetPool build() {
			return new AssetPool.AssetPoolImpl(this);
		}
		
		@Override
		public AssetPool.AssetPoolBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetPool.AssetPoolBuilder prune() {
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getVersion()!=null) return true;
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			if (getInitialFactor()!=null) return true;
			if (getCurrentFactor()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetPool.AssetPoolBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetPool.AssetPoolBuilder o = (AssetPool.AssetPoolBuilder) other;
			
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			
			merger.mergeBasic(getVersion(), o.getVersion(), this::setVersion);
			merger.mergeBasic(getInitialFactor(), o.getInitialFactor(), this::setInitialFactor);
			merger.mergeBasic(getCurrentFactor(), o.getCurrentFactor(), this::setCurrentFactor);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetPool _that = getType().cast(o);
		
			if (!Objects.equals(version, _that.getVersion())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(initialFactor, _that.getInitialFactor())) return false;
			if (!Objects.equals(currentFactor, _that.getCurrentFactor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (initialFactor != null ? initialFactor.hashCode() : 0);
			_result = 31 * _result + (currentFactor != null ? currentFactor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetPoolBuilder {" +
				"version=" + this.version + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"initialFactor=" + this.initialFactor + ", " +
				"currentFactor=" + this.currentFactor +
			'}';
		}
	}
}
