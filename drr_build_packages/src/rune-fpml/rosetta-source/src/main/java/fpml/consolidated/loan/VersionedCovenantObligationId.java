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
import fpml.consolidated.loan.meta.VersionedCovenantObligationIdMeta;
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
 * Provision Covenant Obligation ID with Version Support
 *
 */
@RosettaDataType(value="VersionedCovenantObligationId", builder=VersionedCovenantObligationId.VersionedCovenantObligationIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="VersionedCovenantObligationId", model="fpml", builder=VersionedCovenantObligationId.VersionedCovenantObligationIdBuilderImpl.class, version="2.1.1")
public interface VersionedCovenantObligationId extends RosettaModelObject {

	VersionedCovenantObligationIdMeta metaData = new VersionedCovenantObligationIdMeta();

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
	CovenantObligationId getCovenantObligationId();
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
	VersionedCovenantObligationId build();
	
	VersionedCovenantObligationId.VersionedCovenantObligationIdBuilder toBuilder();
	
	static VersionedCovenantObligationId.VersionedCovenantObligationIdBuilder builder() {
		return new VersionedCovenantObligationId.VersionedCovenantObligationIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VersionedCovenantObligationId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends VersionedCovenantObligationId> getType() {
		return VersionedCovenantObligationId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("covenantObligationId"), processor, CovenantObligationId.class, getCovenantObligationId());
		processor.processBasic(path.newSubPath("version"), Integer.class, getVersion(), this);
		processRosetta(path.newSubPath("effectiveDate"), processor, IdentifiedDate.class, getEffectiveDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface VersionedCovenantObligationIdBuilder extends VersionedCovenantObligationId, RosettaModelObjectBuilder {
		CovenantObligationId.CovenantObligationIdBuilder getOrCreateCovenantObligationId();
		@Override
		CovenantObligationId.CovenantObligationIdBuilder getCovenantObligationId();
		IdentifiedDate.IdentifiedDateBuilder getOrCreateEffectiveDate();
		@Override
		IdentifiedDate.IdentifiedDateBuilder getEffectiveDate();
		VersionedCovenantObligationId.VersionedCovenantObligationIdBuilder setCovenantObligationId(CovenantObligationId covenantObligationId);
		VersionedCovenantObligationId.VersionedCovenantObligationIdBuilder setVersion(Integer version);
		VersionedCovenantObligationId.VersionedCovenantObligationIdBuilder setEffectiveDate(IdentifiedDate effectiveDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("covenantObligationId"), processor, CovenantObligationId.CovenantObligationIdBuilder.class, getCovenantObligationId());
			processor.processBasic(path.newSubPath("version"), Integer.class, getVersion(), this);
			processRosetta(path.newSubPath("effectiveDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getEffectiveDate());
		}
		

		VersionedCovenantObligationId.VersionedCovenantObligationIdBuilder prune();
	}

	/*********************** Immutable Implementation of VersionedCovenantObligationId  ***********************/
	class VersionedCovenantObligationIdImpl implements VersionedCovenantObligationId {
		private final CovenantObligationId covenantObligationId;
		private final Integer version;
		private final IdentifiedDate effectiveDate;
		
		protected VersionedCovenantObligationIdImpl(VersionedCovenantObligationId.VersionedCovenantObligationIdBuilder builder) {
			this.covenantObligationId = ofNullable(builder.getCovenantObligationId()).map(f->f.build()).orElse(null);
			this.version = builder.getVersion();
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("covenantObligationId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("covenantObligationId")
		public CovenantObligationId getCovenantObligationId() {
			return covenantObligationId;
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
		public VersionedCovenantObligationId build() {
			return this;
		}
		
		@Override
		public VersionedCovenantObligationId.VersionedCovenantObligationIdBuilder toBuilder() {
			VersionedCovenantObligationId.VersionedCovenantObligationIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VersionedCovenantObligationId.VersionedCovenantObligationIdBuilder builder) {
			ofNullable(getCovenantObligationId()).ifPresent(builder::setCovenantObligationId);
			ofNullable(getVersion()).ifPresent(builder::setVersion);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			VersionedCovenantObligationId _that = getType().cast(o);
		
			if (!Objects.equals(covenantObligationId, _that.getCovenantObligationId())) return false;
			if (!Objects.equals(version, _that.getVersion())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (covenantObligationId != null ? covenantObligationId.hashCode() : 0);
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VersionedCovenantObligationId {" +
				"covenantObligationId=" + this.covenantObligationId + ", " +
				"version=" + this.version + ", " +
				"effectiveDate=" + this.effectiveDate +
			'}';
		}
	}

	/*********************** Builder Implementation of VersionedCovenantObligationId  ***********************/
	class VersionedCovenantObligationIdBuilderImpl implements VersionedCovenantObligationId.VersionedCovenantObligationIdBuilder {
	
		protected CovenantObligationId.CovenantObligationIdBuilder covenantObligationId;
		protected Integer version;
		protected IdentifiedDate.IdentifiedDateBuilder effectiveDate;
		
		@Override
		@RosettaAttribute("covenantObligationId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("covenantObligationId")
		public CovenantObligationId.CovenantObligationIdBuilder getCovenantObligationId() {
			return covenantObligationId;
		}
		
		@Override
		public CovenantObligationId.CovenantObligationIdBuilder getOrCreateCovenantObligationId() {
			CovenantObligationId.CovenantObligationIdBuilder result;
			if (covenantObligationId!=null) {
				result = covenantObligationId;
			}
			else {
				result = covenantObligationId = CovenantObligationId.builder();
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
		
		@RosettaAttribute("covenantObligationId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("covenantObligationId")
		@Override
		public VersionedCovenantObligationId.VersionedCovenantObligationIdBuilder setCovenantObligationId(CovenantObligationId _covenantObligationId) {
			this.covenantObligationId = _covenantObligationId == null ? null : _covenantObligationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("version")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("version")
		@Override
		public VersionedCovenantObligationId.VersionedCovenantObligationIdBuilder setVersion(Integer _version) {
			this.version = _version == null ? null : _version;
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public VersionedCovenantObligationId.VersionedCovenantObligationIdBuilder setEffectiveDate(IdentifiedDate _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate.toBuilder();
			return this;
		}
		
		@Override
		public VersionedCovenantObligationId build() {
			return new VersionedCovenantObligationId.VersionedCovenantObligationIdImpl(this);
		}
		
		@Override
		public VersionedCovenantObligationId.VersionedCovenantObligationIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VersionedCovenantObligationId.VersionedCovenantObligationIdBuilder prune() {
			if (covenantObligationId!=null && !covenantObligationId.prune().hasData()) covenantObligationId = null;
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCovenantObligationId()!=null && getCovenantObligationId().hasData()) return true;
			if (getVersion()!=null) return true;
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VersionedCovenantObligationId.VersionedCovenantObligationIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			VersionedCovenantObligationId.VersionedCovenantObligationIdBuilder o = (VersionedCovenantObligationId.VersionedCovenantObligationIdBuilder) other;
			
			merger.mergeRosetta(getCovenantObligationId(), o.getCovenantObligationId(), this::setCovenantObligationId);
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			
			merger.mergeBasic(getVersion(), o.getVersion(), this::setVersion);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			VersionedCovenantObligationId _that = getType().cast(o);
		
			if (!Objects.equals(covenantObligationId, _that.getCovenantObligationId())) return false;
			if (!Objects.equals(version, _that.getVersion())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (covenantObligationId != null ? covenantObligationId.hashCode() : 0);
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VersionedCovenantObligationIdBuilder {" +
				"covenantObligationId=" + this.covenantObligationId + ", " +
				"version=" + this.version + ", " +
				"effectiveDate=" + this.effectiveDate +
			'}';
		}
	}
}
