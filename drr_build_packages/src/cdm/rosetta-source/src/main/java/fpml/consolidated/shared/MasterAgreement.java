package fpml.consolidated.shared;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.consolidated.shared.meta.MasterAgreementMeta;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision An entity for defining the agreement executed between the parties and intended to govern all OTC derivatives transactions between those parties.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision An entity for defining the agreement executed between the parties and intended to govern all OTC derivatives transactions between those parties.
 *
 */
@RosettaDataType(value="MasterAgreement", builder=MasterAgreement.MasterAgreementBuilderImpl.class, version="2.1.1")
@RuneDataType(value="MasterAgreement", model="fpml", builder=MasterAgreement.MasterAgreementBuilderImpl.class, version="2.1.1")
public interface MasterAgreement extends RosettaModelObject {

	MasterAgreementMeta metaData = new MasterAgreementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An identifier that has been created to identify the master agreement.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An identifier that has been created to identify the master agreement.
	 *
	 */
	List<? extends MasterAgreementId> getMasterAgreementId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The agreement executed between the parties and intended to govern product-specific derivatives transactions between those parties.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The agreement executed between the parties and intended to govern product-specific derivatives transactions between those parties.
	 *
	 */
	MasterAgreementType getMasterAgreementType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The version of the master agreement.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The version of the master agreement.
	 *
	 */
	MasterAgreementVersion getMasterAgreementVersion();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date on which the master agreement was signed.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which the master agreement was signed.
	 *
	 */
	ZonedDateTime getMasterAgreementDate();

	/*********************** Build Methods  ***********************/
	MasterAgreement build();
	
	MasterAgreement.MasterAgreementBuilder toBuilder();
	
	static MasterAgreement.MasterAgreementBuilder builder() {
		return new MasterAgreement.MasterAgreementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MasterAgreement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MasterAgreement> getType() {
		return MasterAgreement.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("masterAgreementId"), processor, MasterAgreementId.class, getMasterAgreementId());
		processRosetta(path.newSubPath("masterAgreementType"), processor, MasterAgreementType.class, getMasterAgreementType());
		processRosetta(path.newSubPath("masterAgreementVersion"), processor, MasterAgreementVersion.class, getMasterAgreementVersion());
		processor.processBasic(path.newSubPath("masterAgreementDate"), ZonedDateTime.class, getMasterAgreementDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MasterAgreementBuilder extends MasterAgreement, RosettaModelObjectBuilder {
		MasterAgreementId.MasterAgreementIdBuilder getOrCreateMasterAgreementId(int index);
		@Override
		List<? extends MasterAgreementId.MasterAgreementIdBuilder> getMasterAgreementId();
		MasterAgreementType.MasterAgreementTypeBuilder getOrCreateMasterAgreementType();
		@Override
		MasterAgreementType.MasterAgreementTypeBuilder getMasterAgreementType();
		MasterAgreementVersion.MasterAgreementVersionBuilder getOrCreateMasterAgreementVersion();
		@Override
		MasterAgreementVersion.MasterAgreementVersionBuilder getMasterAgreementVersion();
		MasterAgreement.MasterAgreementBuilder addMasterAgreementId(MasterAgreementId masterAgreementId);
		MasterAgreement.MasterAgreementBuilder addMasterAgreementId(MasterAgreementId masterAgreementId, int idx);
		MasterAgreement.MasterAgreementBuilder addMasterAgreementId(List<? extends MasterAgreementId> masterAgreementId);
		MasterAgreement.MasterAgreementBuilder setMasterAgreementId(List<? extends MasterAgreementId> masterAgreementId);
		MasterAgreement.MasterAgreementBuilder setMasterAgreementType(MasterAgreementType masterAgreementType);
		MasterAgreement.MasterAgreementBuilder setMasterAgreementVersion(MasterAgreementVersion masterAgreementVersion);
		MasterAgreement.MasterAgreementBuilder setMasterAgreementDate(ZonedDateTime masterAgreementDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("masterAgreementId"), processor, MasterAgreementId.MasterAgreementIdBuilder.class, getMasterAgreementId());
			processRosetta(path.newSubPath("masterAgreementType"), processor, MasterAgreementType.MasterAgreementTypeBuilder.class, getMasterAgreementType());
			processRosetta(path.newSubPath("masterAgreementVersion"), processor, MasterAgreementVersion.MasterAgreementVersionBuilder.class, getMasterAgreementVersion());
			processor.processBasic(path.newSubPath("masterAgreementDate"), ZonedDateTime.class, getMasterAgreementDate(), this);
		}
		

		MasterAgreement.MasterAgreementBuilder prune();
	}

	/*********************** Immutable Implementation of MasterAgreement  ***********************/
	class MasterAgreementImpl implements MasterAgreement {
		private final List<? extends MasterAgreementId> masterAgreementId;
		private final MasterAgreementType masterAgreementType;
		private final MasterAgreementVersion masterAgreementVersion;
		private final ZonedDateTime masterAgreementDate;
		
		protected MasterAgreementImpl(MasterAgreement.MasterAgreementBuilder builder) {
			this.masterAgreementId = ofNullable(builder.getMasterAgreementId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.masterAgreementType = ofNullable(builder.getMasterAgreementType()).map(f->f.build()).orElse(null);
			this.masterAgreementVersion = ofNullable(builder.getMasterAgreementVersion()).map(f->f.build()).orElse(null);
			this.masterAgreementDate = builder.getMasterAgreementDate();
		}
		
		@Override
		@RosettaAttribute("masterAgreementId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("masterAgreementId")
		public List<? extends MasterAgreementId> getMasterAgreementId() {
			return masterAgreementId;
		}
		
		@Override
		@RosettaAttribute("masterAgreementType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterAgreementType")
		public MasterAgreementType getMasterAgreementType() {
			return masterAgreementType;
		}
		
		@Override
		@RosettaAttribute("masterAgreementVersion")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterAgreementVersion")
		public MasterAgreementVersion getMasterAgreementVersion() {
			return masterAgreementVersion;
		}
		
		@Override
		@RosettaAttribute("masterAgreementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterAgreementDate")
		public ZonedDateTime getMasterAgreementDate() {
			return masterAgreementDate;
		}
		
		@Override
		public MasterAgreement build() {
			return this;
		}
		
		@Override
		public MasterAgreement.MasterAgreementBuilder toBuilder() {
			MasterAgreement.MasterAgreementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MasterAgreement.MasterAgreementBuilder builder) {
			ofNullable(getMasterAgreementId()).ifPresent(builder::setMasterAgreementId);
			ofNullable(getMasterAgreementType()).ifPresent(builder::setMasterAgreementType);
			ofNullable(getMasterAgreementVersion()).ifPresent(builder::setMasterAgreementVersion);
			ofNullable(getMasterAgreementDate()).ifPresent(builder::setMasterAgreementDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MasterAgreement _that = getType().cast(o);
		
			if (!ListEquals.listEquals(masterAgreementId, _that.getMasterAgreementId())) return false;
			if (!Objects.equals(masterAgreementType, _that.getMasterAgreementType())) return false;
			if (!Objects.equals(masterAgreementVersion, _that.getMasterAgreementVersion())) return false;
			if (!Objects.equals(masterAgreementDate, _that.getMasterAgreementDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (masterAgreementId != null ? masterAgreementId.hashCode() : 0);
			_result = 31 * _result + (masterAgreementType != null ? masterAgreementType.hashCode() : 0);
			_result = 31 * _result + (masterAgreementVersion != null ? masterAgreementVersion.hashCode() : 0);
			_result = 31 * _result + (masterAgreementDate != null ? masterAgreementDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterAgreement {" +
				"masterAgreementId=" + this.masterAgreementId + ", " +
				"masterAgreementType=" + this.masterAgreementType + ", " +
				"masterAgreementVersion=" + this.masterAgreementVersion + ", " +
				"masterAgreementDate=" + this.masterAgreementDate +
			'}';
		}
	}

	/*********************** Builder Implementation of MasterAgreement  ***********************/
	class MasterAgreementBuilderImpl implements MasterAgreement.MasterAgreementBuilder {
	
		protected List<MasterAgreementId.MasterAgreementIdBuilder> masterAgreementId = new ArrayList<>();
		protected MasterAgreementType.MasterAgreementTypeBuilder masterAgreementType;
		protected MasterAgreementVersion.MasterAgreementVersionBuilder masterAgreementVersion;
		protected ZonedDateTime masterAgreementDate;
		
		@Override
		@RosettaAttribute("masterAgreementId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("masterAgreementId")
		public List<? extends MasterAgreementId.MasterAgreementIdBuilder> getMasterAgreementId() {
			return masterAgreementId;
		}
		
		@Override
		public MasterAgreementId.MasterAgreementIdBuilder getOrCreateMasterAgreementId(int index) {
			if (masterAgreementId==null) {
				this.masterAgreementId = new ArrayList<>();
			}
			return getIndex(masterAgreementId, index, () -> {
						MasterAgreementId.MasterAgreementIdBuilder newMasterAgreementId = MasterAgreementId.builder();
						return newMasterAgreementId;
					});
		}
		
		@Override
		@RosettaAttribute("masterAgreementType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterAgreementType")
		public MasterAgreementType.MasterAgreementTypeBuilder getMasterAgreementType() {
			return masterAgreementType;
		}
		
		@Override
		public MasterAgreementType.MasterAgreementTypeBuilder getOrCreateMasterAgreementType() {
			MasterAgreementType.MasterAgreementTypeBuilder result;
			if (masterAgreementType!=null) {
				result = masterAgreementType;
			}
			else {
				result = masterAgreementType = MasterAgreementType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("masterAgreementVersion")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterAgreementVersion")
		public MasterAgreementVersion.MasterAgreementVersionBuilder getMasterAgreementVersion() {
			return masterAgreementVersion;
		}
		
		@Override
		public MasterAgreementVersion.MasterAgreementVersionBuilder getOrCreateMasterAgreementVersion() {
			MasterAgreementVersion.MasterAgreementVersionBuilder result;
			if (masterAgreementVersion!=null) {
				result = masterAgreementVersion;
			}
			else {
				result = masterAgreementVersion = MasterAgreementVersion.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("masterAgreementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterAgreementDate")
		public ZonedDateTime getMasterAgreementDate() {
			return masterAgreementDate;
		}
		
		@RosettaAttribute("masterAgreementId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("masterAgreementId")
		@Override
		public MasterAgreement.MasterAgreementBuilder addMasterAgreementId(MasterAgreementId _masterAgreementId) {
			if (_masterAgreementId != null) {
				this.masterAgreementId.add(_masterAgreementId.toBuilder());
			}
			return this;
		}
		
		@Override
		public MasterAgreement.MasterAgreementBuilder addMasterAgreementId(MasterAgreementId _masterAgreementId, int idx) {
			getIndex(this.masterAgreementId, idx, () -> _masterAgreementId.toBuilder());
			return this;
		}
		
		@Override
		public MasterAgreement.MasterAgreementBuilder addMasterAgreementId(List<? extends MasterAgreementId> masterAgreementIds) {
			if (masterAgreementIds != null) {
				for (final MasterAgreementId toAdd : masterAgreementIds) {
					this.masterAgreementId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("masterAgreementId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("masterAgreementId")
		@Override
		public MasterAgreement.MasterAgreementBuilder setMasterAgreementId(List<? extends MasterAgreementId> masterAgreementIds) {
			if (masterAgreementIds == null) {
				this.masterAgreementId = new ArrayList<>();
			} else {
				this.masterAgreementId = masterAgreementIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("masterAgreementType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("masterAgreementType")
		@Override
		public MasterAgreement.MasterAgreementBuilder setMasterAgreementType(MasterAgreementType _masterAgreementType) {
			this.masterAgreementType = _masterAgreementType == null ? null : _masterAgreementType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("masterAgreementVersion")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("masterAgreementVersion")
		@Override
		public MasterAgreement.MasterAgreementBuilder setMasterAgreementVersion(MasterAgreementVersion _masterAgreementVersion) {
			this.masterAgreementVersion = _masterAgreementVersion == null ? null : _masterAgreementVersion.toBuilder();
			return this;
		}
		
		@RosettaAttribute("masterAgreementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("masterAgreementDate")
		@Override
		public MasterAgreement.MasterAgreementBuilder setMasterAgreementDate(ZonedDateTime _masterAgreementDate) {
			this.masterAgreementDate = _masterAgreementDate == null ? null : _masterAgreementDate;
			return this;
		}
		
		@Override
		public MasterAgreement build() {
			return new MasterAgreement.MasterAgreementImpl(this);
		}
		
		@Override
		public MasterAgreement.MasterAgreementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterAgreement.MasterAgreementBuilder prune() {
			masterAgreementId = masterAgreementId.stream().filter(b->b!=null).<MasterAgreementId.MasterAgreementIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (masterAgreementType!=null && !masterAgreementType.prune().hasData()) masterAgreementType = null;
			if (masterAgreementVersion!=null && !masterAgreementVersion.prune().hasData()) masterAgreementVersion = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMasterAgreementId()!=null && getMasterAgreementId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getMasterAgreementType()!=null && getMasterAgreementType().hasData()) return true;
			if (getMasterAgreementVersion()!=null && getMasterAgreementVersion().hasData()) return true;
			if (getMasterAgreementDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterAgreement.MasterAgreementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MasterAgreement.MasterAgreementBuilder o = (MasterAgreement.MasterAgreementBuilder) other;
			
			merger.mergeRosetta(getMasterAgreementId(), o.getMasterAgreementId(), this::getOrCreateMasterAgreementId);
			merger.mergeRosetta(getMasterAgreementType(), o.getMasterAgreementType(), this::setMasterAgreementType);
			merger.mergeRosetta(getMasterAgreementVersion(), o.getMasterAgreementVersion(), this::setMasterAgreementVersion);
			
			merger.mergeBasic(getMasterAgreementDate(), o.getMasterAgreementDate(), this::setMasterAgreementDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MasterAgreement _that = getType().cast(o);
		
			if (!ListEquals.listEquals(masterAgreementId, _that.getMasterAgreementId())) return false;
			if (!Objects.equals(masterAgreementType, _that.getMasterAgreementType())) return false;
			if (!Objects.equals(masterAgreementVersion, _that.getMasterAgreementVersion())) return false;
			if (!Objects.equals(masterAgreementDate, _that.getMasterAgreementDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (masterAgreementId != null ? masterAgreementId.hashCode() : 0);
			_result = 31 * _result + (masterAgreementType != null ? masterAgreementType.hashCode() : 0);
			_result = 31 * _result + (masterAgreementVersion != null ? masterAgreementVersion.hashCode() : 0);
			_result = 31 * _result + (masterAgreementDate != null ? masterAgreementDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterAgreementBuilder {" +
				"masterAgreementId=" + this.masterAgreementId + ", " +
				"masterAgreementType=" + this.masterAgreementType + ", " +
				"masterAgreementVersion=" + this.masterAgreementVersion + ", " +
				"masterAgreementDate=" + this.masterAgreementDate +
			'}';
		}
	}
}
