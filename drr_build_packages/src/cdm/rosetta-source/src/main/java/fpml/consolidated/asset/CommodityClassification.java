package fpml.consolidated.asset;

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
import fpml.consolidated.asset.meta.CommodityClassificationMeta;
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
 * Provision A type containing all commodity classification codes belonging to a specific commodity classification system.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type containing all commodity classification codes belonging to a specific commodity classification system.
 *
 */
@RosettaDataType(value="CommodityClassification", builder=CommodityClassification.CommodityClassificationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityClassification", model="fpml", builder=CommodityClassification.CommodityClassificationBuilderImpl.class, version="2.1.1")
public interface CommodityClassification extends RosettaModelObject {

	CommodityClassificationMeta metaData = new CommodityClassificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies a commodity classification code. The layer and classification system the code belongs to are specified in the coding scheme's URI.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies a commodity classification code. The layer and classification system the code belongs to are specified in the coding scheme's URI.
	 *
	 */
	List<? extends CommodityClassificationLayer> getCode();

	/*********************** Build Methods  ***********************/
	CommodityClassification build();
	
	CommodityClassification.CommodityClassificationBuilder toBuilder();
	
	static CommodityClassification.CommodityClassificationBuilder builder() {
		return new CommodityClassification.CommodityClassificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityClassification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityClassification> getType() {
		return CommodityClassification.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("code"), processor, CommodityClassificationLayer.class, getCode());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityClassificationBuilder extends CommodityClassification, RosettaModelObjectBuilder {
		CommodityClassificationLayer.CommodityClassificationLayerBuilder getOrCreateCode(int index);
		@Override
		List<? extends CommodityClassificationLayer.CommodityClassificationLayerBuilder> getCode();
		CommodityClassification.CommodityClassificationBuilder addCode(CommodityClassificationLayer code);
		CommodityClassification.CommodityClassificationBuilder addCode(CommodityClassificationLayer code, int idx);
		CommodityClassification.CommodityClassificationBuilder addCode(List<? extends CommodityClassificationLayer> code);
		CommodityClassification.CommodityClassificationBuilder setCode(List<? extends CommodityClassificationLayer> code);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("code"), processor, CommodityClassificationLayer.CommodityClassificationLayerBuilder.class, getCode());
		}
		

		CommodityClassification.CommodityClassificationBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityClassification  ***********************/
	class CommodityClassificationImpl implements CommodityClassification {
		private final List<? extends CommodityClassificationLayer> code;
		
		protected CommodityClassificationImpl(CommodityClassification.CommodityClassificationBuilder builder) {
			this.code = ofNullable(builder.getCode()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("code")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("code")
		public List<? extends CommodityClassificationLayer> getCode() {
			return code;
		}
		
		@Override
		public CommodityClassification build() {
			return this;
		}
		
		@Override
		public CommodityClassification.CommodityClassificationBuilder toBuilder() {
			CommodityClassification.CommodityClassificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityClassification.CommodityClassificationBuilder builder) {
			ofNullable(getCode()).ifPresent(builder::setCode);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityClassification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(code, _that.getCode())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (code != null ? code.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityClassification {" +
				"code=" + this.code +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityClassification  ***********************/
	class CommodityClassificationBuilderImpl implements CommodityClassification.CommodityClassificationBuilder {
	
		protected List<CommodityClassificationLayer.CommodityClassificationLayerBuilder> code = new ArrayList<>();
		
		@Override
		@RosettaAttribute("code")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("code")
		public List<? extends CommodityClassificationLayer.CommodityClassificationLayerBuilder> getCode() {
			return code;
		}
		
		@Override
		public CommodityClassificationLayer.CommodityClassificationLayerBuilder getOrCreateCode(int index) {
			if (code==null) {
				this.code = new ArrayList<>();
			}
			return getIndex(code, index, () -> {
						CommodityClassificationLayer.CommodityClassificationLayerBuilder newCode = CommodityClassificationLayer.builder();
						return newCode;
					});
		}
		
		@RosettaAttribute("code")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("code")
		@Override
		public CommodityClassification.CommodityClassificationBuilder addCode(CommodityClassificationLayer _code) {
			if (_code != null) {
				this.code.add(_code.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityClassification.CommodityClassificationBuilder addCode(CommodityClassificationLayer _code, int idx) {
			getIndex(this.code, idx, () -> _code.toBuilder());
			return this;
		}
		
		@Override
		public CommodityClassification.CommodityClassificationBuilder addCode(List<? extends CommodityClassificationLayer> codes) {
			if (codes != null) {
				for (final CommodityClassificationLayer toAdd : codes) {
					this.code.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("code")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("code")
		@Override
		public CommodityClassification.CommodityClassificationBuilder setCode(List<? extends CommodityClassificationLayer> codes) {
			if (codes == null) {
				this.code = new ArrayList<>();
			} else {
				this.code = codes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CommodityClassification build() {
			return new CommodityClassification.CommodityClassificationImpl(this);
		}
		
		@Override
		public CommodityClassification.CommodityClassificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityClassification.CommodityClassificationBuilder prune() {
			code = code.stream().filter(b->b!=null).<CommodityClassificationLayer.CommodityClassificationLayerBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCode()!=null && getCode().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityClassification.CommodityClassificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityClassification.CommodityClassificationBuilder o = (CommodityClassification.CommodityClassificationBuilder) other;
			
			merger.mergeRosetta(getCode(), o.getCode(), this::getOrCreateCode);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityClassification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(code, _that.getCode())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (code != null ? code.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityClassificationBuilder {" +
				"code=" + this.code +
			'}';
		}
	}
}
