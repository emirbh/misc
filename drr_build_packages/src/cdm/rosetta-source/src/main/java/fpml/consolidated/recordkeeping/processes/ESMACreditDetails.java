package fpml.consolidated.recordkeeping.processes;

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
import fpml.consolidated.recordkeeping.processes.meta.ESMACreditDetailsMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="ESMACreditDetails", builder=ESMACreditDetails.ESMACreditDetailsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ESMACreditDetails", model="fpml", builder=ESMACreditDetails.ESMACreditDetailsBuilderImpl.class, version="2.1.1")
public interface ESMACreditDetails extends RosettaModelObject {

	ESMACreditDetailsMeta metaData = new ESMACreditDetailsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	ESMACreditSeniority getSeniority();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	List<BigDecimal> getIndexFactor();

	/*********************** Build Methods  ***********************/
	ESMACreditDetails build();
	
	ESMACreditDetails.ESMACreditDetailsBuilder toBuilder();
	
	static ESMACreditDetails.ESMACreditDetailsBuilder builder() {
		return new ESMACreditDetails.ESMACreditDetailsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ESMACreditDetails> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ESMACreditDetails> getType() {
		return ESMACreditDetails.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("seniority"), processor, ESMACreditSeniority.class, getSeniority());
		processor.processBasic(path.newSubPath("indexFactor"), BigDecimal.class, getIndexFactor(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ESMACreditDetailsBuilder extends ESMACreditDetails, RosettaModelObjectBuilder {
		ESMACreditSeniority.ESMACreditSeniorityBuilder getOrCreateSeniority();
		@Override
		ESMACreditSeniority.ESMACreditSeniorityBuilder getSeniority();
		ESMACreditDetails.ESMACreditDetailsBuilder setSeniority(ESMACreditSeniority seniority);
		ESMACreditDetails.ESMACreditDetailsBuilder addIndexFactor(BigDecimal indexFactor);
		ESMACreditDetails.ESMACreditDetailsBuilder addIndexFactor(BigDecimal indexFactor, int idx);
		ESMACreditDetails.ESMACreditDetailsBuilder addIndexFactor(List<BigDecimal> indexFactor);
		ESMACreditDetails.ESMACreditDetailsBuilder setIndexFactor(List<BigDecimal> indexFactor);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("seniority"), processor, ESMACreditSeniority.ESMACreditSeniorityBuilder.class, getSeniority());
			processor.processBasic(path.newSubPath("indexFactor"), BigDecimal.class, getIndexFactor(), this);
		}
		

		ESMACreditDetails.ESMACreditDetailsBuilder prune();
	}

	/*********************** Immutable Implementation of ESMACreditDetails  ***********************/
	class ESMACreditDetailsImpl implements ESMACreditDetails {
		private final ESMACreditSeniority seniority;
		private final List<BigDecimal> indexFactor;
		
		protected ESMACreditDetailsImpl(ESMACreditDetails.ESMACreditDetailsBuilder builder) {
			this.seniority = ofNullable(builder.getSeniority()).map(f->f.build()).orElse(null);
			this.indexFactor = ofNullable(builder.getIndexFactor()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
		}
		
		@Override
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("seniority")
		public ESMACreditSeniority getSeniority() {
			return seniority;
		}
		
		@Override
		@RosettaAttribute("indexFactor")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("indexFactor")
		public List<BigDecimal> getIndexFactor() {
			return indexFactor;
		}
		
		@Override
		public ESMACreditDetails build() {
			return this;
		}
		
		@Override
		public ESMACreditDetails.ESMACreditDetailsBuilder toBuilder() {
			ESMACreditDetails.ESMACreditDetailsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ESMACreditDetails.ESMACreditDetailsBuilder builder) {
			ofNullable(getSeniority()).ifPresent(builder::setSeniority);
			ofNullable(getIndexFactor()).ifPresent(builder::setIndexFactor);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ESMACreditDetails _that = getType().cast(o);
		
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			if (!ListEquals.listEquals(indexFactor, _that.getIndexFactor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (seniority != null ? seniority.hashCode() : 0);
			_result = 31 * _result + (indexFactor != null ? indexFactor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ESMACreditDetails {" +
				"seniority=" + this.seniority + ", " +
				"indexFactor=" + this.indexFactor +
			'}';
		}
	}

	/*********************** Builder Implementation of ESMACreditDetails  ***********************/
	class ESMACreditDetailsBuilderImpl implements ESMACreditDetails.ESMACreditDetailsBuilder {
	
		protected ESMACreditSeniority.ESMACreditSeniorityBuilder seniority;
		protected List<BigDecimal> indexFactor = new ArrayList<>();
		
		@Override
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("seniority")
		public ESMACreditSeniority.ESMACreditSeniorityBuilder getSeniority() {
			return seniority;
		}
		
		@Override
		public ESMACreditSeniority.ESMACreditSeniorityBuilder getOrCreateSeniority() {
			ESMACreditSeniority.ESMACreditSeniorityBuilder result;
			if (seniority!=null) {
				result = seniority;
			}
			else {
				result = seniority = ESMACreditSeniority.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("indexFactor")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("indexFactor")
		public List<BigDecimal> getIndexFactor() {
			return indexFactor;
		}
		
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("seniority")
		@Override
		public ESMACreditDetails.ESMACreditDetailsBuilder setSeniority(ESMACreditSeniority _seniority) {
			this.seniority = _seniority == null ? null : _seniority.toBuilder();
			return this;
		}
		
		@RosettaAttribute("indexFactor")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("indexFactor")
		@Override
		public ESMACreditDetails.ESMACreditDetailsBuilder addIndexFactor(BigDecimal _indexFactor) {
			if (_indexFactor != null) {
				this.indexFactor.add(_indexFactor);
			}
			return this;
		}
		
		@Override
		public ESMACreditDetails.ESMACreditDetailsBuilder addIndexFactor(BigDecimal _indexFactor, int idx) {
			getIndex(this.indexFactor, idx, () -> _indexFactor);
			return this;
		}
		
		@Override
		public ESMACreditDetails.ESMACreditDetailsBuilder addIndexFactor(List<BigDecimal> indexFactors) {
			if (indexFactors != null) {
				for (final BigDecimal toAdd : indexFactors) {
					this.indexFactor.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("indexFactor")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("indexFactor")
		@Override
		public ESMACreditDetails.ESMACreditDetailsBuilder setIndexFactor(List<BigDecimal> indexFactors) {
			if (indexFactors == null) {
				this.indexFactor = new ArrayList<>();
			} else {
				this.indexFactor = indexFactors.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ESMACreditDetails build() {
			return new ESMACreditDetails.ESMACreditDetailsImpl(this);
		}
		
		@Override
		public ESMACreditDetails.ESMACreditDetailsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ESMACreditDetails.ESMACreditDetailsBuilder prune() {
			if (seniority!=null && !seniority.prune().hasData()) seniority = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSeniority()!=null && getSeniority().hasData()) return true;
			if (getIndexFactor()!=null && !getIndexFactor().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ESMACreditDetails.ESMACreditDetailsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ESMACreditDetails.ESMACreditDetailsBuilder o = (ESMACreditDetails.ESMACreditDetailsBuilder) other;
			
			merger.mergeRosetta(getSeniority(), o.getSeniority(), this::setSeniority);
			
			merger.mergeBasic(getIndexFactor(), o.getIndexFactor(), (Consumer<BigDecimal>) this::addIndexFactor);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ESMACreditDetails _that = getType().cast(o);
		
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			if (!ListEquals.listEquals(indexFactor, _that.getIndexFactor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (seniority != null ? seniority.hashCode() : 0);
			_result = 31 * _result + (indexFactor != null ? indexFactor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ESMACreditDetailsBuilder {" +
				"seniority=" + this.seniority + ", " +
				"indexFactor=" + this.indexFactor +
			'}';
		}
	}
}
