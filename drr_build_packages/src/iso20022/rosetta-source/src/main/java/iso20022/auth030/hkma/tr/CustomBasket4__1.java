package iso20022.auth030.hkma.tr;

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
import iso20022.auth030.hkma.tr.meta.CustomBasket4__1Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Identification of constituents for a basket of indexes.
 * @version ${project.version}
 */
@RosettaDataType(value="CustomBasket4__1", builder=CustomBasket4__1.CustomBasket4__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="CustomBasket4__1", model="iso20022", builder=CustomBasket4__1.CustomBasket4__1BuilderImpl.class, version="${project.version}")
public interface CustomBasket4__1 extends RosettaModelObject {

	CustomBasket4__1Meta metaData = new CustomBasket4__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identification of the structurer of the customer basket.
	 */
	String getStrr();
	/**
	 * Identifier of the custom basket assigned by the structurer allowing to link the constituents of the basket of indexes.
	 */
	String getId();
	/**
	 * Identifier of the underliers that represent the constituents of a custom basket.
	 */
	List<? extends BasketConstituents3__1> getCnsttnts();

	/*********************** Build Methods  ***********************/
	CustomBasket4__1 build();
	
	CustomBasket4__1.CustomBasket4__1Builder toBuilder();
	
	static CustomBasket4__1.CustomBasket4__1Builder builder() {
		return new CustomBasket4__1.CustomBasket4__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CustomBasket4__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CustomBasket4__1> getType() {
		return CustomBasket4__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("strr"), String.class, getStrr(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("cnsttnts"), processor, BasketConstituents3__1.class, getCnsttnts());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CustomBasket4__1Builder extends CustomBasket4__1, RosettaModelObjectBuilder {
		BasketConstituents3__1.BasketConstituents3__1Builder getOrCreateCnsttnts(int index);
		@Override
		List<? extends BasketConstituents3__1.BasketConstituents3__1Builder> getCnsttnts();
		CustomBasket4__1.CustomBasket4__1Builder setStrr(String strr);
		CustomBasket4__1.CustomBasket4__1Builder setId(String id);
		CustomBasket4__1.CustomBasket4__1Builder addCnsttnts(BasketConstituents3__1 cnsttnts);
		CustomBasket4__1.CustomBasket4__1Builder addCnsttnts(BasketConstituents3__1 cnsttnts, int idx);
		CustomBasket4__1.CustomBasket4__1Builder addCnsttnts(List<? extends BasketConstituents3__1> cnsttnts);
		CustomBasket4__1.CustomBasket4__1Builder setCnsttnts(List<? extends BasketConstituents3__1> cnsttnts);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("strr"), String.class, getStrr(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("cnsttnts"), processor, BasketConstituents3__1.BasketConstituents3__1Builder.class, getCnsttnts());
		}
		

		CustomBasket4__1.CustomBasket4__1Builder prune();
	}

	/*********************** Immutable Implementation of CustomBasket4__1  ***********************/
	class CustomBasket4__1Impl implements CustomBasket4__1 {
		private final String strr;
		private final String id;
		private final List<? extends BasketConstituents3__1> cnsttnts;
		
		protected CustomBasket4__1Impl(CustomBasket4__1.CustomBasket4__1Builder builder) {
			this.strr = builder.getStrr();
			this.id = builder.getId();
			this.cnsttnts = ofNullable(builder.getCnsttnts()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("strr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strr")
		public String getStrr() {
			return strr;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("cnsttnts")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cnsttnts")
		public List<? extends BasketConstituents3__1> getCnsttnts() {
			return cnsttnts;
		}
		
		@Override
		public CustomBasket4__1 build() {
			return this;
		}
		
		@Override
		public CustomBasket4__1.CustomBasket4__1Builder toBuilder() {
			CustomBasket4__1.CustomBasket4__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CustomBasket4__1.CustomBasket4__1Builder builder) {
			ofNullable(getStrr()).ifPresent(builder::setStrr);
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getCnsttnts()).ifPresent(builder::setCnsttnts);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CustomBasket4__1 _that = getType().cast(o);
		
			if (!Objects.equals(strr, _that.getStrr())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(cnsttnts, _that.getCnsttnts())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (strr != null ? strr.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (cnsttnts != null ? cnsttnts.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CustomBasket4__1 {" +
				"strr=" + this.strr + ", " +
				"id=" + this.id + ", " +
				"cnsttnts=" + this.cnsttnts +
			'}';
		}
	}

	/*********************** Builder Implementation of CustomBasket4__1  ***********************/
	class CustomBasket4__1BuilderImpl implements CustomBasket4__1.CustomBasket4__1Builder {
	
		protected String strr;
		protected String id;
		protected List<BasketConstituents3__1.BasketConstituents3__1Builder> cnsttnts = new ArrayList<>();
		
		@Override
		@RosettaAttribute("strr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strr")
		public String getStrr() {
			return strr;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("cnsttnts")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cnsttnts")
		public List<? extends BasketConstituents3__1.BasketConstituents3__1Builder> getCnsttnts() {
			return cnsttnts;
		}
		
		@Override
		public BasketConstituents3__1.BasketConstituents3__1Builder getOrCreateCnsttnts(int index) {
			if (cnsttnts==null) {
				this.cnsttnts = new ArrayList<>();
			}
			return getIndex(cnsttnts, index, () -> {
						BasketConstituents3__1.BasketConstituents3__1Builder newCnsttnts = BasketConstituents3__1.builder();
						return newCnsttnts;
					});
		}
		
		@RosettaAttribute("strr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strr")
		@Override
		public CustomBasket4__1.CustomBasket4__1Builder setStrr(String _strr) {
			this.strr = _strr == null ? null : _strr;
			return this;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CustomBasket4__1.CustomBasket4__1Builder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("cnsttnts")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("cnsttnts")
		@Override
		public CustomBasket4__1.CustomBasket4__1Builder addCnsttnts(BasketConstituents3__1 _cnsttnts) {
			if (_cnsttnts != null) {
				this.cnsttnts.add(_cnsttnts.toBuilder());
			}
			return this;
		}
		
		@Override
		public CustomBasket4__1.CustomBasket4__1Builder addCnsttnts(BasketConstituents3__1 _cnsttnts, int idx) {
			getIndex(this.cnsttnts, idx, () -> _cnsttnts.toBuilder());
			return this;
		}
		
		@Override
		public CustomBasket4__1.CustomBasket4__1Builder addCnsttnts(List<? extends BasketConstituents3__1> cnsttntss) {
			if (cnsttntss != null) {
				for (final BasketConstituents3__1 toAdd : cnsttntss) {
					this.cnsttnts.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("cnsttnts")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("cnsttnts")
		@Override
		public CustomBasket4__1.CustomBasket4__1Builder setCnsttnts(List<? extends BasketConstituents3__1> cnsttntss) {
			if (cnsttntss == null) {
				this.cnsttnts = new ArrayList<>();
			} else {
				this.cnsttnts = cnsttntss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CustomBasket4__1 build() {
			return new CustomBasket4__1.CustomBasket4__1Impl(this);
		}
		
		@Override
		public CustomBasket4__1.CustomBasket4__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CustomBasket4__1.CustomBasket4__1Builder prune() {
			cnsttnts = cnsttnts.stream().filter(b->b!=null).<BasketConstituents3__1.BasketConstituents3__1Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStrr()!=null) return true;
			if (getId()!=null) return true;
			if (getCnsttnts()!=null && getCnsttnts().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CustomBasket4__1.CustomBasket4__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CustomBasket4__1.CustomBasket4__1Builder o = (CustomBasket4__1.CustomBasket4__1Builder) other;
			
			merger.mergeRosetta(getCnsttnts(), o.getCnsttnts(), this::getOrCreateCnsttnts);
			
			merger.mergeBasic(getStrr(), o.getStrr(), this::setStrr);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CustomBasket4__1 _that = getType().cast(o);
		
			if (!Objects.equals(strr, _that.getStrr())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(cnsttnts, _that.getCnsttnts())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (strr != null ? strr.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (cnsttnts != null ? cnsttnts.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CustomBasket4__1Builder {" +
				"strr=" + this.strr + ", " +
				"id=" + this.id + ", " +
				"cnsttnts=" + this.cnsttnts +
			'}';
		}
	}
}
