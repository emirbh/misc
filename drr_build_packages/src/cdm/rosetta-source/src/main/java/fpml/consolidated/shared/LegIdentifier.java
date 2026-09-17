package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.LegIdentifierMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Version aware identification of a leg.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Version aware identification of a leg.
 *
 */
@RosettaDataType(value="LegIdentifier", builder=LegIdentifier.LegIdentifierBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LegIdentifier", model="fpml", builder=LegIdentifier.LegIdentifierBuilderImpl.class, version="2.1.1")
public interface LegIdentifier extends RosettaModelObject {

	LegIdentifierMeta metaData = new LegIdentifierMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identity of this leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Identity of this leg.
	 *
	 */
	LegId getLegId();
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
	LegIdentifier build();
	
	LegIdentifier.LegIdentifierBuilder toBuilder();
	
	static LegIdentifier.LegIdentifierBuilder builder() {
		return new LegIdentifier.LegIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LegIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LegIdentifier> getType() {
		return LegIdentifier.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("legId"), processor, LegId.class, getLegId());
		processor.processBasic(path.newSubPath("version"), Integer.class, getVersion(), this);
		processRosetta(path.newSubPath("effectiveDate"), processor, IdentifiedDate.class, getEffectiveDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LegIdentifierBuilder extends LegIdentifier, RosettaModelObjectBuilder {
		LegId.LegIdBuilder getOrCreateLegId();
		@Override
		LegId.LegIdBuilder getLegId();
		IdentifiedDate.IdentifiedDateBuilder getOrCreateEffectiveDate();
		@Override
		IdentifiedDate.IdentifiedDateBuilder getEffectiveDate();
		LegIdentifier.LegIdentifierBuilder setLegId(LegId legId);
		LegIdentifier.LegIdentifierBuilder setVersion(Integer version);
		LegIdentifier.LegIdentifierBuilder setEffectiveDate(IdentifiedDate effectiveDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("legId"), processor, LegId.LegIdBuilder.class, getLegId());
			processor.processBasic(path.newSubPath("version"), Integer.class, getVersion(), this);
			processRosetta(path.newSubPath("effectiveDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getEffectiveDate());
		}
		

		LegIdentifier.LegIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of LegIdentifier  ***********************/
	class LegIdentifierImpl implements LegIdentifier {
		private final LegId legId;
		private final Integer version;
		private final IdentifiedDate effectiveDate;
		
		protected LegIdentifierImpl(LegIdentifier.LegIdentifierBuilder builder) {
			this.legId = ofNullable(builder.getLegId()).map(f->f.build()).orElse(null);
			this.version = builder.getVersion();
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("legId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legId")
		public LegId getLegId() {
			return legId;
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
		public LegIdentifier build() {
			return this;
		}
		
		@Override
		public LegIdentifier.LegIdentifierBuilder toBuilder() {
			LegIdentifier.LegIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LegIdentifier.LegIdentifierBuilder builder) {
			ofNullable(getLegId()).ifPresent(builder::setLegId);
			ofNullable(getVersion()).ifPresent(builder::setVersion);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(legId, _that.getLegId())) return false;
			if (!Objects.equals(version, _that.getVersion())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (legId != null ? legId.hashCode() : 0);
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegIdentifier {" +
				"legId=" + this.legId + ", " +
				"version=" + this.version + ", " +
				"effectiveDate=" + this.effectiveDate +
			'}';
		}
	}

	/*********************** Builder Implementation of LegIdentifier  ***********************/
	class LegIdentifierBuilderImpl implements LegIdentifier.LegIdentifierBuilder {
	
		protected LegId.LegIdBuilder legId;
		protected Integer version;
		protected IdentifiedDate.IdentifiedDateBuilder effectiveDate;
		
		@Override
		@RosettaAttribute("legId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legId")
		public LegId.LegIdBuilder getLegId() {
			return legId;
		}
		
		@Override
		public LegId.LegIdBuilder getOrCreateLegId() {
			LegId.LegIdBuilder result;
			if (legId!=null) {
				result = legId;
			}
			else {
				result = legId = LegId.builder();
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
		
		@RosettaAttribute("legId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legId")
		@Override
		public LegIdentifier.LegIdentifierBuilder setLegId(LegId _legId) {
			this.legId = _legId == null ? null : _legId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("version")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("version")
		@Override
		public LegIdentifier.LegIdentifierBuilder setVersion(Integer _version) {
			this.version = _version == null ? null : _version;
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public LegIdentifier.LegIdentifierBuilder setEffectiveDate(IdentifiedDate _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate.toBuilder();
			return this;
		}
		
		@Override
		public LegIdentifier build() {
			return new LegIdentifier.LegIdentifierImpl(this);
		}
		
		@Override
		public LegIdentifier.LegIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegIdentifier.LegIdentifierBuilder prune() {
			if (legId!=null && !legId.prune().hasData()) legId = null;
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLegId()!=null && getLegId().hasData()) return true;
			if (getVersion()!=null) return true;
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegIdentifier.LegIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LegIdentifier.LegIdentifierBuilder o = (LegIdentifier.LegIdentifierBuilder) other;
			
			merger.mergeRosetta(getLegId(), o.getLegId(), this::setLegId);
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			
			merger.mergeBasic(getVersion(), o.getVersion(), this::setVersion);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(legId, _that.getLegId())) return false;
			if (!Objects.equals(version, _that.getVersion())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (legId != null ? legId.hashCode() : 0);
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegIdentifierBuilder {" +
				"legId=" + this.legId + ", " +
				"version=" + this.version + ", " +
				"effectiveDate=" + this.effectiveDate +
			'}';
		}
	}
}
