package iso20022.auth030.hkma.dtcc;

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
import iso20022.auth030.hkma.dtcc.meta.SecurityIdentification41Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Choice between ISIN and an alternative format for the identification of a financial instrument. ISIN is the preferred format.
 * @version ${project.version}
 */
@RosettaDataType(value="SecurityIdentification41Choice__1", builder=SecurityIdentification41Choice__1.SecurityIdentification41Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="SecurityIdentification41Choice__1", model="iso20022", builder=SecurityIdentification41Choice__1.SecurityIdentification41Choice__1BuilderImpl.class, version="${project.version}")
public interface SecurityIdentification41Choice__1 extends RosettaModelObject {

	SecurityIdentification41Choice__1Meta metaData = new SecurityIdentification41Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * International Securities Identification Number (ISIN). A numbering system designed by the United Nation&#39;s International Organisation for Standardisation (ISO). The ISIN is composed of a 2-character prefix representing the country of issue, followed by the national security number (if one exists), and a check digit. Each country has a national numbering agency that assigns ISIN numbers for securities in that country.
	 */
	String getIsin();
	/**
	 * Identification of constituents for a basket of indexes.
	 */
	CustomBasket4__1 getBskt();
	/**
	 * Indicates the index upon which the financial instrument is based.
	 */
	IndexIdentification1__1 getIndx();
	/**
	 * Other identification of an underlier.
	 */
	GenericIdentification184 getOthr();

	/*********************** Build Methods  ***********************/
	SecurityIdentification41Choice__1 build();
	
	SecurityIdentification41Choice__1.SecurityIdentification41Choice__1Builder toBuilder();
	
	static SecurityIdentification41Choice__1.SecurityIdentification41Choice__1Builder builder() {
		return new SecurityIdentification41Choice__1.SecurityIdentification41Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SecurityIdentification41Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SecurityIdentification41Choice__1> getType() {
		return SecurityIdentification41Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isin"), String.class, getIsin(), this);
		processRosetta(path.newSubPath("bskt"), processor, CustomBasket4__1.class, getBskt());
		processRosetta(path.newSubPath("indx"), processor, IndexIdentification1__1.class, getIndx());
		processRosetta(path.newSubPath("othr"), processor, GenericIdentification184.class, getOthr());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SecurityIdentification41Choice__1Builder extends SecurityIdentification41Choice__1, RosettaModelObjectBuilder {
		CustomBasket4__1.CustomBasket4__1Builder getOrCreateBskt();
		@Override
		CustomBasket4__1.CustomBasket4__1Builder getBskt();
		IndexIdentification1__1.IndexIdentification1__1Builder getOrCreateIndx();
		@Override
		IndexIdentification1__1.IndexIdentification1__1Builder getIndx();
		GenericIdentification184.GenericIdentification184Builder getOrCreateOthr();
		@Override
		GenericIdentification184.GenericIdentification184Builder getOthr();
		SecurityIdentification41Choice__1.SecurityIdentification41Choice__1Builder setIsin(String isin);
		SecurityIdentification41Choice__1.SecurityIdentification41Choice__1Builder setBskt(CustomBasket4__1 bskt);
		SecurityIdentification41Choice__1.SecurityIdentification41Choice__1Builder setIndx(IndexIdentification1__1 indx);
		SecurityIdentification41Choice__1.SecurityIdentification41Choice__1Builder setOthr(GenericIdentification184 othr);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("isin"), String.class, getIsin(), this);
			processRosetta(path.newSubPath("bskt"), processor, CustomBasket4__1.CustomBasket4__1Builder.class, getBskt());
			processRosetta(path.newSubPath("indx"), processor, IndexIdentification1__1.IndexIdentification1__1Builder.class, getIndx());
			processRosetta(path.newSubPath("othr"), processor, GenericIdentification184.GenericIdentification184Builder.class, getOthr());
		}
		

		SecurityIdentification41Choice__1.SecurityIdentification41Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of SecurityIdentification41Choice__1  ***********************/
	class SecurityIdentification41Choice__1Impl implements SecurityIdentification41Choice__1 {
		private final String isin;
		private final CustomBasket4__1 bskt;
		private final IndexIdentification1__1 indx;
		private final GenericIdentification184 othr;
		
		protected SecurityIdentification41Choice__1Impl(SecurityIdentification41Choice__1.SecurityIdentification41Choice__1Builder builder) {
			this.isin = builder.getIsin();
			this.bskt = ofNullable(builder.getBskt()).map(f->f.build()).orElse(null);
			this.indx = ofNullable(builder.getIndx()).map(f->f.build()).orElse(null);
			this.othr = ofNullable(builder.getOthr()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("isin")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isin")
		public String getIsin() {
			return isin;
		}
		
		@Override
		@RosettaAttribute("bskt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bskt")
		public CustomBasket4__1 getBskt() {
			return bskt;
		}
		
		@Override
		@RosettaAttribute("indx")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indx")
		public IndexIdentification1__1 getIndx() {
			return indx;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public GenericIdentification184 getOthr() {
			return othr;
		}
		
		@Override
		public SecurityIdentification41Choice__1 build() {
			return this;
		}
		
		@Override
		public SecurityIdentification41Choice__1.SecurityIdentification41Choice__1Builder toBuilder() {
			SecurityIdentification41Choice__1.SecurityIdentification41Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SecurityIdentification41Choice__1.SecurityIdentification41Choice__1Builder builder) {
			ofNullable(getIsin()).ifPresent(builder::setIsin);
			ofNullable(getBskt()).ifPresent(builder::setBskt);
			ofNullable(getIndx()).ifPresent(builder::setIndx);
			ofNullable(getOthr()).ifPresent(builder::setOthr);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecurityIdentification41Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(isin, _that.getIsin())) return false;
			if (!Objects.equals(bskt, _that.getBskt())) return false;
			if (!Objects.equals(indx, _that.getIndx())) return false;
			if (!Objects.equals(othr, _that.getOthr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isin != null ? isin.hashCode() : 0);
			_result = 31 * _result + (bskt != null ? bskt.hashCode() : 0);
			_result = 31 * _result + (indx != null ? indx.hashCode() : 0);
			_result = 31 * _result + (othr != null ? othr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityIdentification41Choice__1 {" +
				"isin=" + this.isin + ", " +
				"bskt=" + this.bskt + ", " +
				"indx=" + this.indx + ", " +
				"othr=" + this.othr +
			'}';
		}
	}

	/*********************** Builder Implementation of SecurityIdentification41Choice__1  ***********************/
	class SecurityIdentification41Choice__1BuilderImpl implements SecurityIdentification41Choice__1.SecurityIdentification41Choice__1Builder {
	
		protected String isin;
		protected CustomBasket4__1.CustomBasket4__1Builder bskt;
		protected IndexIdentification1__1.IndexIdentification1__1Builder indx;
		protected GenericIdentification184.GenericIdentification184Builder othr;
		
		@Override
		@RosettaAttribute("isin")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isin")
		public String getIsin() {
			return isin;
		}
		
		@Override
		@RosettaAttribute("bskt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bskt")
		public CustomBasket4__1.CustomBasket4__1Builder getBskt() {
			return bskt;
		}
		
		@Override
		public CustomBasket4__1.CustomBasket4__1Builder getOrCreateBskt() {
			CustomBasket4__1.CustomBasket4__1Builder result;
			if (bskt!=null) {
				result = bskt;
			}
			else {
				result = bskt = CustomBasket4__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("indx")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indx")
		public IndexIdentification1__1.IndexIdentification1__1Builder getIndx() {
			return indx;
		}
		
		@Override
		public IndexIdentification1__1.IndexIdentification1__1Builder getOrCreateIndx() {
			IndexIdentification1__1.IndexIdentification1__1Builder result;
			if (indx!=null) {
				result = indx;
			}
			else {
				result = indx = IndexIdentification1__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public GenericIdentification184.GenericIdentification184Builder getOthr() {
			return othr;
		}
		
		@Override
		public GenericIdentification184.GenericIdentification184Builder getOrCreateOthr() {
			GenericIdentification184.GenericIdentification184Builder result;
			if (othr!=null) {
				result = othr;
			}
			else {
				result = othr = GenericIdentification184.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("isin")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isin")
		@Override
		public SecurityIdentification41Choice__1.SecurityIdentification41Choice__1Builder setIsin(String _isin) {
			this.isin = _isin == null ? null : _isin;
			return this;
		}
		
		@RosettaAttribute("bskt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("bskt")
		@Override
		public SecurityIdentification41Choice__1.SecurityIdentification41Choice__1Builder setBskt(CustomBasket4__1 _bskt) {
			this.bskt = _bskt == null ? null : _bskt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("indx")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indx")
		@Override
		public SecurityIdentification41Choice__1.SecurityIdentification41Choice__1Builder setIndx(IndexIdentification1__1 _indx) {
			this.indx = _indx == null ? null : _indx.toBuilder();
			return this;
		}
		
		@RosettaAttribute("othr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("othr")
		@Override
		public SecurityIdentification41Choice__1.SecurityIdentification41Choice__1Builder setOthr(GenericIdentification184 _othr) {
			this.othr = _othr == null ? null : _othr.toBuilder();
			return this;
		}
		
		@Override
		public SecurityIdentification41Choice__1 build() {
			return new SecurityIdentification41Choice__1.SecurityIdentification41Choice__1Impl(this);
		}
		
		@Override
		public SecurityIdentification41Choice__1.SecurityIdentification41Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityIdentification41Choice__1.SecurityIdentification41Choice__1Builder prune() {
			if (bskt!=null && !bskt.prune().hasData()) bskt = null;
			if (indx!=null && !indx.prune().hasData()) indx = null;
			if (othr!=null && !othr.prune().hasData()) othr = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIsin()!=null) return true;
			if (getBskt()!=null && getBskt().hasData()) return true;
			if (getIndx()!=null && getIndx().hasData()) return true;
			if (getOthr()!=null && getOthr().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityIdentification41Choice__1.SecurityIdentification41Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SecurityIdentification41Choice__1.SecurityIdentification41Choice__1Builder o = (SecurityIdentification41Choice__1.SecurityIdentification41Choice__1Builder) other;
			
			merger.mergeRosetta(getBskt(), o.getBskt(), this::setBskt);
			merger.mergeRosetta(getIndx(), o.getIndx(), this::setIndx);
			merger.mergeRosetta(getOthr(), o.getOthr(), this::setOthr);
			
			merger.mergeBasic(getIsin(), o.getIsin(), this::setIsin);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecurityIdentification41Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(isin, _that.getIsin())) return false;
			if (!Objects.equals(bskt, _that.getBskt())) return false;
			if (!Objects.equals(indx, _that.getIndx())) return false;
			if (!Objects.equals(othr, _that.getOthr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isin != null ? isin.hashCode() : 0);
			_result = 31 * _result + (bskt != null ? bskt.hashCode() : 0);
			_result = 31 * _result + (indx != null ? indx.hashCode() : 0);
			_result = 31 * _result + (othr != null ? othr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityIdentification41Choice__1Builder {" +
				"isin=" + this.isin + ", " +
				"bskt=" + this.bskt + ", " +
				"indx=" + this.indx + ", " +
				"othr=" + this.othr +
			'}';
		}
	}
}
