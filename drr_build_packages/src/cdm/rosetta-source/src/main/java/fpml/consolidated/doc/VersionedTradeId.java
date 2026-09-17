package fpml.consolidated.doc;

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
import fpml.consolidated.doc.meta.VersionedTradeIdMeta;
import fpml.consolidated.shared.IdentifiedDate;
import fpml.consolidated.shared.TradeId;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Trade Id with Version Support
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Trade Id with Version Support
 *
 */
@RosettaDataType(value="VersionedTradeId", builder=VersionedTradeId.VersionedTradeIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="VersionedTradeId", model="fpml", builder=VersionedTradeId.VersionedTradeIdBuilderImpl.class, version="2.1.1")
public interface VersionedTradeId extends RosettaModelObject {

	VersionedTradeIdMeta metaData = new VersionedTradeIdMeta();

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
	TradeId getTradeId();
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

	/*********************** Build Methods  ***********************/
	VersionedTradeId build();
	
	VersionedTradeId.VersionedTradeIdBuilder toBuilder();
	
	static VersionedTradeId.VersionedTradeIdBuilder builder() {
		return new VersionedTradeId.VersionedTradeIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VersionedTradeId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends VersionedTradeId> getType() {
		return VersionedTradeId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("tradeId"), processor, TradeId.class, getTradeId());
		processor.processBasic(path.newSubPath("version"), Integer.class, getVersion(), this);
		processRosetta(path.newSubPath("effectiveDate"), processor, IdentifiedDate.class, getEffectiveDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface VersionedTradeIdBuilder extends VersionedTradeId, RosettaModelObjectBuilder {
		TradeId.TradeIdBuilder getOrCreateTradeId();
		@Override
		TradeId.TradeIdBuilder getTradeId();
		IdentifiedDate.IdentifiedDateBuilder getOrCreateEffectiveDate();
		@Override
		IdentifiedDate.IdentifiedDateBuilder getEffectiveDate();
		VersionedTradeId.VersionedTradeIdBuilder setTradeId(TradeId tradeId);
		VersionedTradeId.VersionedTradeIdBuilder setVersion(Integer version);
		VersionedTradeId.VersionedTradeIdBuilder setEffectiveDate(IdentifiedDate effectiveDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("tradeId"), processor, TradeId.TradeIdBuilder.class, getTradeId());
			processor.processBasic(path.newSubPath("version"), Integer.class, getVersion(), this);
			processRosetta(path.newSubPath("effectiveDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getEffectiveDate());
		}
		

		VersionedTradeId.VersionedTradeIdBuilder prune();
	}

	/*********************** Immutable Implementation of VersionedTradeId  ***********************/
	class VersionedTradeIdImpl implements VersionedTradeId {
		private final TradeId tradeId;
		private final Integer version;
		private final IdentifiedDate effectiveDate;
		
		protected VersionedTradeIdImpl(VersionedTradeId.VersionedTradeIdBuilder builder) {
			this.tradeId = ofNullable(builder.getTradeId()).map(f->f.build()).orElse(null);
			this.version = builder.getVersion();
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradeId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeId")
		public TradeId getTradeId() {
			return tradeId;
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
		public VersionedTradeId build() {
			return this;
		}
		
		@Override
		public VersionedTradeId.VersionedTradeIdBuilder toBuilder() {
			VersionedTradeId.VersionedTradeIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VersionedTradeId.VersionedTradeIdBuilder builder) {
			ofNullable(getTradeId()).ifPresent(builder::setTradeId);
			ofNullable(getVersion()).ifPresent(builder::setVersion);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			VersionedTradeId _that = getType().cast(o);
		
			if (!Objects.equals(tradeId, _that.getTradeId())) return false;
			if (!Objects.equals(version, _that.getVersion())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeId != null ? tradeId.hashCode() : 0);
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VersionedTradeId {" +
				"tradeId=" + this.tradeId + ", " +
				"version=" + this.version + ", " +
				"effectiveDate=" + this.effectiveDate +
			'}';
		}
	}

	/*********************** Builder Implementation of VersionedTradeId  ***********************/
	class VersionedTradeIdBuilderImpl implements VersionedTradeId.VersionedTradeIdBuilder {
	
		protected TradeId.TradeIdBuilder tradeId;
		protected Integer version;
		protected IdentifiedDate.IdentifiedDateBuilder effectiveDate;
		
		@Override
		@RosettaAttribute("tradeId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeId")
		public TradeId.TradeIdBuilder getTradeId() {
			return tradeId;
		}
		
		@Override
		public TradeId.TradeIdBuilder getOrCreateTradeId() {
			TradeId.TradeIdBuilder result;
			if (tradeId!=null) {
				result = tradeId;
			}
			else {
				result = tradeId = TradeId.builder();
			}
			
			return result;
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
		
		@RosettaAttribute("tradeId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeId")
		@Override
		public VersionedTradeId.VersionedTradeIdBuilder setTradeId(TradeId _tradeId) {
			this.tradeId = _tradeId == null ? null : _tradeId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("version")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("version")
		@Override
		public VersionedTradeId.VersionedTradeIdBuilder setVersion(Integer _version) {
			this.version = _version == null ? null : _version;
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public VersionedTradeId.VersionedTradeIdBuilder setEffectiveDate(IdentifiedDate _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate.toBuilder();
			return this;
		}
		
		@Override
		public VersionedTradeId build() {
			return new VersionedTradeId.VersionedTradeIdImpl(this);
		}
		
		@Override
		public VersionedTradeId.VersionedTradeIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VersionedTradeId.VersionedTradeIdBuilder prune() {
			if (tradeId!=null && !tradeId.prune().hasData()) tradeId = null;
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTradeId()!=null && getTradeId().hasData()) return true;
			if (getVersion()!=null) return true;
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VersionedTradeId.VersionedTradeIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			VersionedTradeId.VersionedTradeIdBuilder o = (VersionedTradeId.VersionedTradeIdBuilder) other;
			
			merger.mergeRosetta(getTradeId(), o.getTradeId(), this::setTradeId);
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			
			merger.mergeBasic(getVersion(), o.getVersion(), this::setVersion);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			VersionedTradeId _that = getType().cast(o);
		
			if (!Objects.equals(tradeId, _that.getTradeId())) return false;
			if (!Objects.equals(version, _that.getVersion())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeId != null ? tradeId.hashCode() : 0);
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VersionedTradeIdBuilder {" +
				"tradeId=" + this.tradeId + ", " +
				"version=" + this.version + ", " +
				"effectiveDate=" + this.effectiveDate +
			'}';
		}
	}
}
