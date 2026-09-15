package fpml.consolidated.cd;

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
import fpml.consolidated.cd.meta.IndexReferenceInformationMeta;
import fpml.consolidated.shared.CreditSeniority;
import fpml.consolidated.shared.LegalEntity;
import java.math.BigDecimal;
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
 * Provision A type defining a Credit Default Swap Index.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a Credit Default Swap Index.
 *
 */
@RosettaDataType(value="IndexReferenceInformation", builder=IndexReferenceInformation.IndexReferenceInformationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="IndexReferenceInformation", model="fpml", builder=IndexReferenceInformation.IndexReferenceInformationBuilderImpl.class, version="2.1.1")
public interface IndexReferenceInformation extends RosettaModelObject {

	IndexReferenceInformationMeta metaData = new IndexReferenceInformationMeta();

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
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The name of the index expressed as a free format string. FpML does not define usage rules for this element.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The name of the index expressed as a free format string. FpML does not define usage rules for this element.
	 *
	 */
	IndexName getIndexName();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A CDS index identifier (e.g. RED pair code).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A CDS index identifier (e.g. RED pair code).
	 *
	 */
	List<? extends IndexId> getIndexId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A CDS index series identifier, e.g. 1, 2, 3 etc.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A CDS index series identifier, e.g. 1, 2, 3 etc.
	 *
	 */
	Integer getIndexSeries();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A CDS index series version identifier, e.g. 1, 2, 3 etc.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A CDS index series version identifier, e.g. 1, 2, 3 etc.
	 *
	 */
	Integer getIndexAnnexVersion();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A CDS index series annex date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A CDS index series annex date.
	 *
	 */
	ZonedDateTime getIndexAnnexDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A CDS index series annex source.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A CDS index series annex source.
	 *
	 */
	IndexAnnexSource getIndexAnnexSource();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Excluded reference entity.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Excluded reference entity.
	 *
	 */
	List<? extends LegalEntity> getExcludedReferenceEntity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This element contains CDS tranche terms.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This element contains CDS tranche terms.
	 *
	 */
	Tranche getTranche();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Used to specify the Relevant Settled Entity Matrix when there are settled entities at the time of the trade.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Used to specify the Relevant Settled Entity Matrix when there are settled entities at the time of the trade.
	 *
	 */
	SettledEntityMatrix getSettledEntityMatrix();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Index Factor is the index version factor or percent, expressed as an absolute decimal value between 0 and 1, that multiplied by the original notional amount yields the notional amount covered by the seller of protection.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Index Factor is the index version factor or percent, expressed as an absolute decimal value between 0 and 1, that multiplied by the original notional amount yields the notional amount covered by the seller of protection.
	 *
	 */
	BigDecimal getIndexFactor();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Seniority of debt instruments comprising the index.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Seniority of debt instruments comprising the index.
	 *
	 */
	CreditSeniority getSeniority();

	/*********************** Build Methods  ***********************/
	IndexReferenceInformation build();
	
	IndexReferenceInformation.IndexReferenceInformationBuilder toBuilder();
	
	static IndexReferenceInformation.IndexReferenceInformationBuilder builder() {
		return new IndexReferenceInformation.IndexReferenceInformationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IndexReferenceInformation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends IndexReferenceInformation> getType() {
		return IndexReferenceInformation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("indexName"), processor, IndexName.class, getIndexName());
		processRosetta(path.newSubPath("indexId"), processor, IndexId.class, getIndexId());
		processor.processBasic(path.newSubPath("indexSeries"), Integer.class, getIndexSeries(), this);
		processor.processBasic(path.newSubPath("indexAnnexVersion"), Integer.class, getIndexAnnexVersion(), this);
		processor.processBasic(path.newSubPath("indexAnnexDate"), ZonedDateTime.class, getIndexAnnexDate(), this);
		processRosetta(path.newSubPath("indexAnnexSource"), processor, IndexAnnexSource.class, getIndexAnnexSource());
		processRosetta(path.newSubPath("excludedReferenceEntity"), processor, LegalEntity.class, getExcludedReferenceEntity());
		processRosetta(path.newSubPath("tranche"), processor, Tranche.class, getTranche());
		processRosetta(path.newSubPath("settledEntityMatrix"), processor, SettledEntityMatrix.class, getSettledEntityMatrix());
		processor.processBasic(path.newSubPath("indexFactor"), BigDecimal.class, getIndexFactor(), this);
		processRosetta(path.newSubPath("seniority"), processor, CreditSeniority.class, getSeniority());
	}
	

	/*********************** Builder Interface  ***********************/
	interface IndexReferenceInformationBuilder extends IndexReferenceInformation, RosettaModelObjectBuilder {
		IndexName.IndexNameBuilder getOrCreateIndexName();
		@Override
		IndexName.IndexNameBuilder getIndexName();
		IndexId.IndexIdBuilder getOrCreateIndexId(int index);
		@Override
		List<? extends IndexId.IndexIdBuilder> getIndexId();
		IndexAnnexSource.IndexAnnexSourceBuilder getOrCreateIndexAnnexSource();
		@Override
		IndexAnnexSource.IndexAnnexSourceBuilder getIndexAnnexSource();
		LegalEntity.LegalEntityBuilder getOrCreateExcludedReferenceEntity(int index);
		@Override
		List<? extends LegalEntity.LegalEntityBuilder> getExcludedReferenceEntity();
		Tranche.TrancheBuilder getOrCreateTranche();
		@Override
		Tranche.TrancheBuilder getTranche();
		SettledEntityMatrix.SettledEntityMatrixBuilder getOrCreateSettledEntityMatrix();
		@Override
		SettledEntityMatrix.SettledEntityMatrixBuilder getSettledEntityMatrix();
		CreditSeniority.CreditSeniorityBuilder getOrCreateSeniority();
		@Override
		CreditSeniority.CreditSeniorityBuilder getSeniority();
		IndexReferenceInformation.IndexReferenceInformationBuilder setId(String id);
		IndexReferenceInformation.IndexReferenceInformationBuilder setIndexName(IndexName indexName);
		IndexReferenceInformation.IndexReferenceInformationBuilder addIndexId(IndexId indexId);
		IndexReferenceInformation.IndexReferenceInformationBuilder addIndexId(IndexId indexId, int idx);
		IndexReferenceInformation.IndexReferenceInformationBuilder addIndexId(List<? extends IndexId> indexId);
		IndexReferenceInformation.IndexReferenceInformationBuilder setIndexId(List<? extends IndexId> indexId);
		IndexReferenceInformation.IndexReferenceInformationBuilder setIndexSeries(Integer indexSeries);
		IndexReferenceInformation.IndexReferenceInformationBuilder setIndexAnnexVersion(Integer indexAnnexVersion);
		IndexReferenceInformation.IndexReferenceInformationBuilder setIndexAnnexDate(ZonedDateTime indexAnnexDate);
		IndexReferenceInformation.IndexReferenceInformationBuilder setIndexAnnexSource(IndexAnnexSource indexAnnexSource);
		IndexReferenceInformation.IndexReferenceInformationBuilder addExcludedReferenceEntity(LegalEntity excludedReferenceEntity);
		IndexReferenceInformation.IndexReferenceInformationBuilder addExcludedReferenceEntity(LegalEntity excludedReferenceEntity, int idx);
		IndexReferenceInformation.IndexReferenceInformationBuilder addExcludedReferenceEntity(List<? extends LegalEntity> excludedReferenceEntity);
		IndexReferenceInformation.IndexReferenceInformationBuilder setExcludedReferenceEntity(List<? extends LegalEntity> excludedReferenceEntity);
		IndexReferenceInformation.IndexReferenceInformationBuilder setTranche(Tranche tranche);
		IndexReferenceInformation.IndexReferenceInformationBuilder setSettledEntityMatrix(SettledEntityMatrix settledEntityMatrix);
		IndexReferenceInformation.IndexReferenceInformationBuilder setIndexFactor(BigDecimal indexFactor);
		IndexReferenceInformation.IndexReferenceInformationBuilder setSeniority(CreditSeniority seniority);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("indexName"), processor, IndexName.IndexNameBuilder.class, getIndexName());
			processRosetta(path.newSubPath("indexId"), processor, IndexId.IndexIdBuilder.class, getIndexId());
			processor.processBasic(path.newSubPath("indexSeries"), Integer.class, getIndexSeries(), this);
			processor.processBasic(path.newSubPath("indexAnnexVersion"), Integer.class, getIndexAnnexVersion(), this);
			processor.processBasic(path.newSubPath("indexAnnexDate"), ZonedDateTime.class, getIndexAnnexDate(), this);
			processRosetta(path.newSubPath("indexAnnexSource"), processor, IndexAnnexSource.IndexAnnexSourceBuilder.class, getIndexAnnexSource());
			processRosetta(path.newSubPath("excludedReferenceEntity"), processor, LegalEntity.LegalEntityBuilder.class, getExcludedReferenceEntity());
			processRosetta(path.newSubPath("tranche"), processor, Tranche.TrancheBuilder.class, getTranche());
			processRosetta(path.newSubPath("settledEntityMatrix"), processor, SettledEntityMatrix.SettledEntityMatrixBuilder.class, getSettledEntityMatrix());
			processor.processBasic(path.newSubPath("indexFactor"), BigDecimal.class, getIndexFactor(), this);
			processRosetta(path.newSubPath("seniority"), processor, CreditSeniority.CreditSeniorityBuilder.class, getSeniority());
		}
		

		IndexReferenceInformation.IndexReferenceInformationBuilder prune();
	}

	/*********************** Immutable Implementation of IndexReferenceInformation  ***********************/
	class IndexReferenceInformationImpl implements IndexReferenceInformation {
		private final String id;
		private final IndexName indexName;
		private final List<? extends IndexId> indexId;
		private final Integer indexSeries;
		private final Integer indexAnnexVersion;
		private final ZonedDateTime indexAnnexDate;
		private final IndexAnnexSource indexAnnexSource;
		private final List<? extends LegalEntity> excludedReferenceEntity;
		private final Tranche tranche;
		private final SettledEntityMatrix settledEntityMatrix;
		private final BigDecimal indexFactor;
		private final CreditSeniority seniority;
		
		protected IndexReferenceInformationImpl(IndexReferenceInformation.IndexReferenceInformationBuilder builder) {
			this.id = builder.getId();
			this.indexName = ofNullable(builder.getIndexName()).map(f->f.build()).orElse(null);
			this.indexId = ofNullable(builder.getIndexId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.indexSeries = builder.getIndexSeries();
			this.indexAnnexVersion = builder.getIndexAnnexVersion();
			this.indexAnnexDate = builder.getIndexAnnexDate();
			this.indexAnnexSource = ofNullable(builder.getIndexAnnexSource()).map(f->f.build()).orElse(null);
			this.excludedReferenceEntity = ofNullable(builder.getExcludedReferenceEntity()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.tranche = ofNullable(builder.getTranche()).map(f->f.build()).orElse(null);
			this.settledEntityMatrix = ofNullable(builder.getSettledEntityMatrix()).map(f->f.build()).orElse(null);
			this.indexFactor = builder.getIndexFactor();
			this.seniority = ofNullable(builder.getSeniority()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("indexName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexName")
		public IndexName getIndexName() {
			return indexName;
		}
		
		@Override
		@RosettaAttribute("indexId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("indexId")
		public List<? extends IndexId> getIndexId() {
			return indexId;
		}
		
		@Override
		@RosettaAttribute("indexSeries")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexSeries")
		public Integer getIndexSeries() {
			return indexSeries;
		}
		
		@Override
		@RosettaAttribute("indexAnnexVersion")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexAnnexVersion")
		public Integer getIndexAnnexVersion() {
			return indexAnnexVersion;
		}
		
		@Override
		@RosettaAttribute("indexAnnexDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexAnnexDate")
		public ZonedDateTime getIndexAnnexDate() {
			return indexAnnexDate;
		}
		
		@Override
		@RosettaAttribute("indexAnnexSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexAnnexSource")
		public IndexAnnexSource getIndexAnnexSource() {
			return indexAnnexSource;
		}
		
		@Override
		@RosettaAttribute("excludedReferenceEntity")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("excludedReferenceEntity")
		public List<? extends LegalEntity> getExcludedReferenceEntity() {
			return excludedReferenceEntity;
		}
		
		@Override
		@RosettaAttribute("tranche")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tranche")
		public Tranche getTranche() {
			return tranche;
		}
		
		@Override
		@RosettaAttribute("settledEntityMatrix")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settledEntityMatrix")
		public SettledEntityMatrix getSettledEntityMatrix() {
			return settledEntityMatrix;
		}
		
		@Override
		@RosettaAttribute("indexFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexFactor")
		public BigDecimal getIndexFactor() {
			return indexFactor;
		}
		
		@Override
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("seniority")
		public CreditSeniority getSeniority() {
			return seniority;
		}
		
		@Override
		public IndexReferenceInformation build() {
			return this;
		}
		
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder toBuilder() {
			IndexReferenceInformation.IndexReferenceInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IndexReferenceInformation.IndexReferenceInformationBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getIndexName()).ifPresent(builder::setIndexName);
			ofNullable(getIndexId()).ifPresent(builder::setIndexId);
			ofNullable(getIndexSeries()).ifPresent(builder::setIndexSeries);
			ofNullable(getIndexAnnexVersion()).ifPresent(builder::setIndexAnnexVersion);
			ofNullable(getIndexAnnexDate()).ifPresent(builder::setIndexAnnexDate);
			ofNullable(getIndexAnnexSource()).ifPresent(builder::setIndexAnnexSource);
			ofNullable(getExcludedReferenceEntity()).ifPresent(builder::setExcludedReferenceEntity);
			ofNullable(getTranche()).ifPresent(builder::setTranche);
			ofNullable(getSettledEntityMatrix()).ifPresent(builder::setSettledEntityMatrix);
			ofNullable(getIndexFactor()).ifPresent(builder::setIndexFactor);
			ofNullable(getSeniority()).ifPresent(builder::setSeniority);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndexReferenceInformation _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(indexName, _that.getIndexName())) return false;
			if (!ListEquals.listEquals(indexId, _that.getIndexId())) return false;
			if (!Objects.equals(indexSeries, _that.getIndexSeries())) return false;
			if (!Objects.equals(indexAnnexVersion, _that.getIndexAnnexVersion())) return false;
			if (!Objects.equals(indexAnnexDate, _that.getIndexAnnexDate())) return false;
			if (!Objects.equals(indexAnnexSource, _that.getIndexAnnexSource())) return false;
			if (!ListEquals.listEquals(excludedReferenceEntity, _that.getExcludedReferenceEntity())) return false;
			if (!Objects.equals(tranche, _that.getTranche())) return false;
			if (!Objects.equals(settledEntityMatrix, _that.getSettledEntityMatrix())) return false;
			if (!Objects.equals(indexFactor, _that.getIndexFactor())) return false;
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (indexName != null ? indexName.hashCode() : 0);
			_result = 31 * _result + (indexId != null ? indexId.hashCode() : 0);
			_result = 31 * _result + (indexSeries != null ? indexSeries.hashCode() : 0);
			_result = 31 * _result + (indexAnnexVersion != null ? indexAnnexVersion.hashCode() : 0);
			_result = 31 * _result + (indexAnnexDate != null ? indexAnnexDate.hashCode() : 0);
			_result = 31 * _result + (indexAnnexSource != null ? indexAnnexSource.hashCode() : 0);
			_result = 31 * _result + (excludedReferenceEntity != null ? excludedReferenceEntity.hashCode() : 0);
			_result = 31 * _result + (tranche != null ? tranche.hashCode() : 0);
			_result = 31 * _result + (settledEntityMatrix != null ? settledEntityMatrix.hashCode() : 0);
			_result = 31 * _result + (indexFactor != null ? indexFactor.hashCode() : 0);
			_result = 31 * _result + (seniority != null ? seniority.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexReferenceInformation {" +
				"id=" + this.id + ", " +
				"indexName=" + this.indexName + ", " +
				"indexId=" + this.indexId + ", " +
				"indexSeries=" + this.indexSeries + ", " +
				"indexAnnexVersion=" + this.indexAnnexVersion + ", " +
				"indexAnnexDate=" + this.indexAnnexDate + ", " +
				"indexAnnexSource=" + this.indexAnnexSource + ", " +
				"excludedReferenceEntity=" + this.excludedReferenceEntity + ", " +
				"tranche=" + this.tranche + ", " +
				"settledEntityMatrix=" + this.settledEntityMatrix + ", " +
				"indexFactor=" + this.indexFactor + ", " +
				"seniority=" + this.seniority +
			'}';
		}
	}

	/*********************** Builder Implementation of IndexReferenceInformation  ***********************/
	class IndexReferenceInformationBuilderImpl implements IndexReferenceInformation.IndexReferenceInformationBuilder {
	
		protected String id;
		protected IndexName.IndexNameBuilder indexName;
		protected List<IndexId.IndexIdBuilder> indexId = new ArrayList<>();
		protected Integer indexSeries;
		protected Integer indexAnnexVersion;
		protected ZonedDateTime indexAnnexDate;
		protected IndexAnnexSource.IndexAnnexSourceBuilder indexAnnexSource;
		protected List<LegalEntity.LegalEntityBuilder> excludedReferenceEntity = new ArrayList<>();
		protected Tranche.TrancheBuilder tranche;
		protected SettledEntityMatrix.SettledEntityMatrixBuilder settledEntityMatrix;
		protected BigDecimal indexFactor;
		protected CreditSeniority.CreditSeniorityBuilder seniority;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("indexName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexName")
		public IndexName.IndexNameBuilder getIndexName() {
			return indexName;
		}
		
		@Override
		public IndexName.IndexNameBuilder getOrCreateIndexName() {
			IndexName.IndexNameBuilder result;
			if (indexName!=null) {
				result = indexName;
			}
			else {
				result = indexName = IndexName.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("indexId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("indexId")
		public List<? extends IndexId.IndexIdBuilder> getIndexId() {
			return indexId;
		}
		
		@Override
		public IndexId.IndexIdBuilder getOrCreateIndexId(int index) {
			if (indexId==null) {
				this.indexId = new ArrayList<>();
			}
			return getIndex(indexId, index, () -> {
						IndexId.IndexIdBuilder newIndexId = IndexId.builder();
						return newIndexId;
					});
		}
		
		@Override
		@RosettaAttribute("indexSeries")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexSeries")
		public Integer getIndexSeries() {
			return indexSeries;
		}
		
		@Override
		@RosettaAttribute("indexAnnexVersion")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexAnnexVersion")
		public Integer getIndexAnnexVersion() {
			return indexAnnexVersion;
		}
		
		@Override
		@RosettaAttribute("indexAnnexDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexAnnexDate")
		public ZonedDateTime getIndexAnnexDate() {
			return indexAnnexDate;
		}
		
		@Override
		@RosettaAttribute("indexAnnexSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexAnnexSource")
		public IndexAnnexSource.IndexAnnexSourceBuilder getIndexAnnexSource() {
			return indexAnnexSource;
		}
		
		@Override
		public IndexAnnexSource.IndexAnnexSourceBuilder getOrCreateIndexAnnexSource() {
			IndexAnnexSource.IndexAnnexSourceBuilder result;
			if (indexAnnexSource!=null) {
				result = indexAnnexSource;
			}
			else {
				result = indexAnnexSource = IndexAnnexSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("excludedReferenceEntity")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("excludedReferenceEntity")
		public List<? extends LegalEntity.LegalEntityBuilder> getExcludedReferenceEntity() {
			return excludedReferenceEntity;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getOrCreateExcludedReferenceEntity(int index) {
			if (excludedReferenceEntity==null) {
				this.excludedReferenceEntity = new ArrayList<>();
			}
			return getIndex(excludedReferenceEntity, index, () -> {
						LegalEntity.LegalEntityBuilder newExcludedReferenceEntity = LegalEntity.builder();
						return newExcludedReferenceEntity;
					});
		}
		
		@Override
		@RosettaAttribute("tranche")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tranche")
		public Tranche.TrancheBuilder getTranche() {
			return tranche;
		}
		
		@Override
		public Tranche.TrancheBuilder getOrCreateTranche() {
			Tranche.TrancheBuilder result;
			if (tranche!=null) {
				result = tranche;
			}
			else {
				result = tranche = Tranche.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settledEntityMatrix")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settledEntityMatrix")
		public SettledEntityMatrix.SettledEntityMatrixBuilder getSettledEntityMatrix() {
			return settledEntityMatrix;
		}
		
		@Override
		public SettledEntityMatrix.SettledEntityMatrixBuilder getOrCreateSettledEntityMatrix() {
			SettledEntityMatrix.SettledEntityMatrixBuilder result;
			if (settledEntityMatrix!=null) {
				result = settledEntityMatrix;
			}
			else {
				result = settledEntityMatrix = SettledEntityMatrix.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("indexFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexFactor")
		public BigDecimal getIndexFactor() {
			return indexFactor;
		}
		
		@Override
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("seniority")
		public CreditSeniority.CreditSeniorityBuilder getSeniority() {
			return seniority;
		}
		
		@Override
		public CreditSeniority.CreditSeniorityBuilder getOrCreateSeniority() {
			CreditSeniority.CreditSeniorityBuilder result;
			if (seniority!=null) {
				result = seniority;
			}
			else {
				result = seniority = CreditSeniority.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("indexName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexName")
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder setIndexName(IndexName _indexName) {
			this.indexName = _indexName == null ? null : _indexName.toBuilder();
			return this;
		}
		
		@RosettaAttribute("indexId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("indexId")
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder addIndexId(IndexId _indexId) {
			if (_indexId != null) {
				this.indexId.add(_indexId.toBuilder());
			}
			return this;
		}
		
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder addIndexId(IndexId _indexId, int idx) {
			getIndex(this.indexId, idx, () -> _indexId.toBuilder());
			return this;
		}
		
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder addIndexId(List<? extends IndexId> indexIds) {
			if (indexIds != null) {
				for (final IndexId toAdd : indexIds) {
					this.indexId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("indexId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("indexId")
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder setIndexId(List<? extends IndexId> indexIds) {
			if (indexIds == null) {
				this.indexId = new ArrayList<>();
			} else {
				this.indexId = indexIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("indexSeries")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexSeries")
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder setIndexSeries(Integer _indexSeries) {
			this.indexSeries = _indexSeries == null ? null : _indexSeries;
			return this;
		}
		
		@RosettaAttribute("indexAnnexVersion")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexAnnexVersion")
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder setIndexAnnexVersion(Integer _indexAnnexVersion) {
			this.indexAnnexVersion = _indexAnnexVersion == null ? null : _indexAnnexVersion;
			return this;
		}
		
		@RosettaAttribute("indexAnnexDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexAnnexDate")
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder setIndexAnnexDate(ZonedDateTime _indexAnnexDate) {
			this.indexAnnexDate = _indexAnnexDate == null ? null : _indexAnnexDate;
			return this;
		}
		
		@RosettaAttribute("indexAnnexSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexAnnexSource")
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder setIndexAnnexSource(IndexAnnexSource _indexAnnexSource) {
			this.indexAnnexSource = _indexAnnexSource == null ? null : _indexAnnexSource.toBuilder();
			return this;
		}
		
		@RosettaAttribute("excludedReferenceEntity")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("excludedReferenceEntity")
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder addExcludedReferenceEntity(LegalEntity _excludedReferenceEntity) {
			if (_excludedReferenceEntity != null) {
				this.excludedReferenceEntity.add(_excludedReferenceEntity.toBuilder());
			}
			return this;
		}
		
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder addExcludedReferenceEntity(LegalEntity _excludedReferenceEntity, int idx) {
			getIndex(this.excludedReferenceEntity, idx, () -> _excludedReferenceEntity.toBuilder());
			return this;
		}
		
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder addExcludedReferenceEntity(List<? extends LegalEntity> excludedReferenceEntitys) {
			if (excludedReferenceEntitys != null) {
				for (final LegalEntity toAdd : excludedReferenceEntitys) {
					this.excludedReferenceEntity.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("excludedReferenceEntity")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("excludedReferenceEntity")
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder setExcludedReferenceEntity(List<? extends LegalEntity> excludedReferenceEntitys) {
			if (excludedReferenceEntitys == null) {
				this.excludedReferenceEntity = new ArrayList<>();
			} else {
				this.excludedReferenceEntity = excludedReferenceEntitys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("tranche")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tranche")
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder setTranche(Tranche _tranche) {
			this.tranche = _tranche == null ? null : _tranche.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settledEntityMatrix")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settledEntityMatrix")
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder setSettledEntityMatrix(SettledEntityMatrix _settledEntityMatrix) {
			this.settledEntityMatrix = _settledEntityMatrix == null ? null : _settledEntityMatrix.toBuilder();
			return this;
		}
		
		@RosettaAttribute("indexFactor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexFactor")
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder setIndexFactor(BigDecimal _indexFactor) {
			this.indexFactor = _indexFactor == null ? null : _indexFactor;
			return this;
		}
		
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("seniority")
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder setSeniority(CreditSeniority _seniority) {
			this.seniority = _seniority == null ? null : _seniority.toBuilder();
			return this;
		}
		
		@Override
		public IndexReferenceInformation build() {
			return new IndexReferenceInformation.IndexReferenceInformationImpl(this);
		}
		
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder prune() {
			if (indexName!=null && !indexName.prune().hasData()) indexName = null;
			indexId = indexId.stream().filter(b->b!=null).<IndexId.IndexIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (indexAnnexSource!=null && !indexAnnexSource.prune().hasData()) indexAnnexSource = null;
			excludedReferenceEntity = excludedReferenceEntity.stream().filter(b->b!=null).<LegalEntity.LegalEntityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (tranche!=null && !tranche.prune().hasData()) tranche = null;
			if (settledEntityMatrix!=null && !settledEntityMatrix.prune().hasData()) settledEntityMatrix = null;
			if (seniority!=null && !seniority.prune().hasData()) seniority = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getIndexName()!=null && getIndexName().hasData()) return true;
			if (getIndexId()!=null && getIndexId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getIndexSeries()!=null) return true;
			if (getIndexAnnexVersion()!=null) return true;
			if (getIndexAnnexDate()!=null) return true;
			if (getIndexAnnexSource()!=null && getIndexAnnexSource().hasData()) return true;
			if (getExcludedReferenceEntity()!=null && getExcludedReferenceEntity().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTranche()!=null && getTranche().hasData()) return true;
			if (getSettledEntityMatrix()!=null && getSettledEntityMatrix().hasData()) return true;
			if (getIndexFactor()!=null) return true;
			if (getSeniority()!=null && getSeniority().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IndexReferenceInformation.IndexReferenceInformationBuilder o = (IndexReferenceInformation.IndexReferenceInformationBuilder) other;
			
			merger.mergeRosetta(getIndexName(), o.getIndexName(), this::setIndexName);
			merger.mergeRosetta(getIndexId(), o.getIndexId(), this::getOrCreateIndexId);
			merger.mergeRosetta(getIndexAnnexSource(), o.getIndexAnnexSource(), this::setIndexAnnexSource);
			merger.mergeRosetta(getExcludedReferenceEntity(), o.getExcludedReferenceEntity(), this::getOrCreateExcludedReferenceEntity);
			merger.mergeRosetta(getTranche(), o.getTranche(), this::setTranche);
			merger.mergeRosetta(getSettledEntityMatrix(), o.getSettledEntityMatrix(), this::setSettledEntityMatrix);
			merger.mergeRosetta(getSeniority(), o.getSeniority(), this::setSeniority);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getIndexSeries(), o.getIndexSeries(), this::setIndexSeries);
			merger.mergeBasic(getIndexAnnexVersion(), o.getIndexAnnexVersion(), this::setIndexAnnexVersion);
			merger.mergeBasic(getIndexAnnexDate(), o.getIndexAnnexDate(), this::setIndexAnnexDate);
			merger.mergeBasic(getIndexFactor(), o.getIndexFactor(), this::setIndexFactor);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndexReferenceInformation _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(indexName, _that.getIndexName())) return false;
			if (!ListEquals.listEquals(indexId, _that.getIndexId())) return false;
			if (!Objects.equals(indexSeries, _that.getIndexSeries())) return false;
			if (!Objects.equals(indexAnnexVersion, _that.getIndexAnnexVersion())) return false;
			if (!Objects.equals(indexAnnexDate, _that.getIndexAnnexDate())) return false;
			if (!Objects.equals(indexAnnexSource, _that.getIndexAnnexSource())) return false;
			if (!ListEquals.listEquals(excludedReferenceEntity, _that.getExcludedReferenceEntity())) return false;
			if (!Objects.equals(tranche, _that.getTranche())) return false;
			if (!Objects.equals(settledEntityMatrix, _that.getSettledEntityMatrix())) return false;
			if (!Objects.equals(indexFactor, _that.getIndexFactor())) return false;
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (indexName != null ? indexName.hashCode() : 0);
			_result = 31 * _result + (indexId != null ? indexId.hashCode() : 0);
			_result = 31 * _result + (indexSeries != null ? indexSeries.hashCode() : 0);
			_result = 31 * _result + (indexAnnexVersion != null ? indexAnnexVersion.hashCode() : 0);
			_result = 31 * _result + (indexAnnexDate != null ? indexAnnexDate.hashCode() : 0);
			_result = 31 * _result + (indexAnnexSource != null ? indexAnnexSource.hashCode() : 0);
			_result = 31 * _result + (excludedReferenceEntity != null ? excludedReferenceEntity.hashCode() : 0);
			_result = 31 * _result + (tranche != null ? tranche.hashCode() : 0);
			_result = 31 * _result + (settledEntityMatrix != null ? settledEntityMatrix.hashCode() : 0);
			_result = 31 * _result + (indexFactor != null ? indexFactor.hashCode() : 0);
			_result = 31 * _result + (seniority != null ? seniority.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexReferenceInformationBuilder {" +
				"id=" + this.id + ", " +
				"indexName=" + this.indexName + ", " +
				"indexId=" + this.indexId + ", " +
				"indexSeries=" + this.indexSeries + ", " +
				"indexAnnexVersion=" + this.indexAnnexVersion + ", " +
				"indexAnnexDate=" + this.indexAnnexDate + ", " +
				"indexAnnexSource=" + this.indexAnnexSource + ", " +
				"excludedReferenceEntity=" + this.excludedReferenceEntity + ", " +
				"tranche=" + this.tranche + ", " +
				"settledEntityMatrix=" + this.settledEntityMatrix + ", " +
				"indexFactor=" + this.indexFactor + ", " +
				"seniority=" + this.seniority +
			'}';
		}
	}
}
