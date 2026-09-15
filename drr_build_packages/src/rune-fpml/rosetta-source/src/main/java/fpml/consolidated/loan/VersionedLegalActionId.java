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
import fpml.consolidated.loan.meta.VersionedLegalActionIdMeta;
import fpml.consolidated.shared.IdentifiedDate;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Legal Action ID with Version Support
 *
 */
@RosettaDataType(value="VersionedLegalActionId", builder=VersionedLegalActionId.VersionedLegalActionIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="VersionedLegalActionId", model="fpml", builder=VersionedLegalActionId.VersionedLegalActionIdBuilderImpl.class, version="2.1.1")
public interface VersionedLegalActionId extends RosettaModelObject {

	VersionedLegalActionIdMeta metaData = new VersionedLegalActionIdMeta();

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
	LegalActionId getLegalActionId();
	/**
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
	 * version "confirmation-5.13"
	 *
	 * Provision Optionally it is possible to specify a version effective date when a versionId is supplied.
	 *
	 */
	IdentifiedDate getEffectiveDate();

	/*********************** Build Methods  ***********************/
	VersionedLegalActionId build();
	
	VersionedLegalActionId.VersionedLegalActionIdBuilder toBuilder();
	
	static VersionedLegalActionId.VersionedLegalActionIdBuilder builder() {
		return new VersionedLegalActionId.VersionedLegalActionIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VersionedLegalActionId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends VersionedLegalActionId> getType() {
		return VersionedLegalActionId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("legalActionId"), processor, LegalActionId.class, getLegalActionId());
		processor.processBasic(path.newSubPath("version"), Integer.class, getVersion(), this);
		processRosetta(path.newSubPath("effectiveDate"), processor, IdentifiedDate.class, getEffectiveDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface VersionedLegalActionIdBuilder extends VersionedLegalActionId, RosettaModelObjectBuilder {
		LegalActionId.LegalActionIdBuilder getOrCreateLegalActionId();
		@Override
		LegalActionId.LegalActionIdBuilder getLegalActionId();
		IdentifiedDate.IdentifiedDateBuilder getOrCreateEffectiveDate();
		@Override
		IdentifiedDate.IdentifiedDateBuilder getEffectiveDate();
		VersionedLegalActionId.VersionedLegalActionIdBuilder setLegalActionId(LegalActionId legalActionId);
		VersionedLegalActionId.VersionedLegalActionIdBuilder setVersion(Integer version);
		VersionedLegalActionId.VersionedLegalActionIdBuilder setEffectiveDate(IdentifiedDate effectiveDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("legalActionId"), processor, LegalActionId.LegalActionIdBuilder.class, getLegalActionId());
			processor.processBasic(path.newSubPath("version"), Integer.class, getVersion(), this);
			processRosetta(path.newSubPath("effectiveDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getEffectiveDate());
		}
		

		VersionedLegalActionId.VersionedLegalActionIdBuilder prune();
	}

	/*********************** Immutable Implementation of VersionedLegalActionId  ***********************/
	class VersionedLegalActionIdImpl implements VersionedLegalActionId {
		private final LegalActionId legalActionId;
		private final Integer version;
		private final IdentifiedDate effectiveDate;
		
		protected VersionedLegalActionIdImpl(VersionedLegalActionId.VersionedLegalActionIdBuilder builder) {
			this.legalActionId = ofNullable(builder.getLegalActionId()).map(f->f.build()).orElse(null);
			this.version = builder.getVersion();
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("legalActionId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("legalActionId")
		public LegalActionId getLegalActionId() {
			return legalActionId;
		}
		
		@Override
		@RosettaAttribute("version")
		@Accessor(AccessorType.GETTER)
		@Required
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
		public VersionedLegalActionId build() {
			return this;
		}
		
		@Override
		public VersionedLegalActionId.VersionedLegalActionIdBuilder toBuilder() {
			VersionedLegalActionId.VersionedLegalActionIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VersionedLegalActionId.VersionedLegalActionIdBuilder builder) {
			ofNullable(getLegalActionId()).ifPresent(builder::setLegalActionId);
			ofNullable(getVersion()).ifPresent(builder::setVersion);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			VersionedLegalActionId _that = getType().cast(o);
		
			if (!Objects.equals(legalActionId, _that.getLegalActionId())) return false;
			if (!Objects.equals(version, _that.getVersion())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (legalActionId != null ? legalActionId.hashCode() : 0);
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VersionedLegalActionId {" +
				"legalActionId=" + this.legalActionId + ", " +
				"version=" + this.version + ", " +
				"effectiveDate=" + this.effectiveDate +
			'}';
		}
	}

	/*********************** Builder Implementation of VersionedLegalActionId  ***********************/
	class VersionedLegalActionIdBuilderImpl implements VersionedLegalActionId.VersionedLegalActionIdBuilder {
	
		protected LegalActionId.LegalActionIdBuilder legalActionId;
		protected Integer version;
		protected IdentifiedDate.IdentifiedDateBuilder effectiveDate;
		
		@Override
		@RosettaAttribute("legalActionId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("legalActionId")
		public LegalActionId.LegalActionIdBuilder getLegalActionId() {
			return legalActionId;
		}
		
		@Override
		public LegalActionId.LegalActionIdBuilder getOrCreateLegalActionId() {
			LegalActionId.LegalActionIdBuilder result;
			if (legalActionId!=null) {
				result = legalActionId;
			}
			else {
				result = legalActionId = LegalActionId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("version")
		@Accessor(AccessorType.GETTER)
		@Required
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
		
		@RosettaAttribute("legalActionId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("legalActionId")
		@Override
		public VersionedLegalActionId.VersionedLegalActionIdBuilder setLegalActionId(LegalActionId _legalActionId) {
			this.legalActionId = _legalActionId == null ? null : _legalActionId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("version")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("version")
		@Override
		public VersionedLegalActionId.VersionedLegalActionIdBuilder setVersion(Integer _version) {
			this.version = _version == null ? null : _version;
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public VersionedLegalActionId.VersionedLegalActionIdBuilder setEffectiveDate(IdentifiedDate _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate.toBuilder();
			return this;
		}
		
		@Override
		public VersionedLegalActionId build() {
			return new VersionedLegalActionId.VersionedLegalActionIdImpl(this);
		}
		
		@Override
		public VersionedLegalActionId.VersionedLegalActionIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VersionedLegalActionId.VersionedLegalActionIdBuilder prune() {
			if (legalActionId!=null && !legalActionId.prune().hasData()) legalActionId = null;
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLegalActionId()!=null && getLegalActionId().hasData()) return true;
			if (getVersion()!=null) return true;
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VersionedLegalActionId.VersionedLegalActionIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			VersionedLegalActionId.VersionedLegalActionIdBuilder o = (VersionedLegalActionId.VersionedLegalActionIdBuilder) other;
			
			merger.mergeRosetta(getLegalActionId(), o.getLegalActionId(), this::setLegalActionId);
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			
			merger.mergeBasic(getVersion(), o.getVersion(), this::setVersion);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			VersionedLegalActionId _that = getType().cast(o);
		
			if (!Objects.equals(legalActionId, _that.getLegalActionId())) return false;
			if (!Objects.equals(version, _that.getVersion())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (legalActionId != null ? legalActionId.hashCode() : 0);
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VersionedLegalActionIdBuilder {" +
				"legalActionId=" + this.legalActionId + ", " +
				"version=" + this.version + ", " +
				"effectiveDate=" + this.effectiveDate +
			'}';
		}
	}
}
