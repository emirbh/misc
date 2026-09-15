package iso20022.auth030.esma;

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
import iso20022.auth030.esma.meta.IndexIdentification1__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies the elements for the identification of an index. ISIN is the preferred format.
 * @version ${project.version}
 */
@RosettaDataType(value="IndexIdentification1__1", builder=IndexIdentification1__1.IndexIdentification1__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="IndexIdentification1__1", model="iso20022", builder=IndexIdentification1__1.IndexIdentification1__1BuilderImpl.class, version="${project.version}")
public interface IndexIdentification1__1 extends RosettaModelObject {

	IndexIdentification1__1Meta metaData = new IndexIdentification1__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * International Securities Identification Number (ISIN). A numbering system designed by the United Nation&#39;s International Organisation for Standardisation (ISO). The ISIN is composed of a 2-character prefix representing the country of issue, followed by the national security number (if one exists), and a check digit. Each country has a national numbering agency that assigns ISIN numbers for securities in that country.
	 */
	String getIsin();
	/**
	 * Proprietary identification of the index on which the financial instrument is based.
	 */
	String getNm();
	/**
	 * Index name where the underlying is an index.
	 */
	FloatingRateIndex1Code getIndx();

	/*********************** Build Methods  ***********************/
	IndexIdentification1__1 build();
	
	IndexIdentification1__1.IndexIdentification1__1Builder toBuilder();
	
	static IndexIdentification1__1.IndexIdentification1__1Builder builder() {
		return new IndexIdentification1__1.IndexIdentification1__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IndexIdentification1__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends IndexIdentification1__1> getType() {
		return IndexIdentification1__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isin"), String.class, getIsin(), this);
		processor.processBasic(path.newSubPath("nm"), String.class, getNm(), this);
		processor.processBasic(path.newSubPath("indx"), FloatingRateIndex1Code.class, getIndx(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface IndexIdentification1__1Builder extends IndexIdentification1__1, RosettaModelObjectBuilder {
		IndexIdentification1__1.IndexIdentification1__1Builder setIsin(String isin);
		IndexIdentification1__1.IndexIdentification1__1Builder setNm(String nm);
		IndexIdentification1__1.IndexIdentification1__1Builder setIndx(FloatingRateIndex1Code indx);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("isin"), String.class, getIsin(), this);
			processor.processBasic(path.newSubPath("nm"), String.class, getNm(), this);
			processor.processBasic(path.newSubPath("indx"), FloatingRateIndex1Code.class, getIndx(), this);
		}
		

		IndexIdentification1__1.IndexIdentification1__1Builder prune();
	}

	/*********************** Immutable Implementation of IndexIdentification1__1  ***********************/
	class IndexIdentification1__1Impl implements IndexIdentification1__1 {
		private final String isin;
		private final String nm;
		private final FloatingRateIndex1Code indx;
		
		protected IndexIdentification1__1Impl(IndexIdentification1__1.IndexIdentification1__1Builder builder) {
			this.isin = builder.getIsin();
			this.nm = builder.getNm();
			this.indx = builder.getIndx();
		}
		
		@Override
		@RosettaAttribute("isin")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isin")
		public String getIsin() {
			return isin;
		}
		
		@Override
		@RosettaAttribute("nm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nm")
		public String getNm() {
			return nm;
		}
		
		@Override
		@RosettaAttribute("indx")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indx")
		public FloatingRateIndex1Code getIndx() {
			return indx;
		}
		
		@Override
		public IndexIdentification1__1 build() {
			return this;
		}
		
		@Override
		public IndexIdentification1__1.IndexIdentification1__1Builder toBuilder() {
			IndexIdentification1__1.IndexIdentification1__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IndexIdentification1__1.IndexIdentification1__1Builder builder) {
			ofNullable(getIsin()).ifPresent(builder::setIsin);
			ofNullable(getNm()).ifPresent(builder::setNm);
			ofNullable(getIndx()).ifPresent(builder::setIndx);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndexIdentification1__1 _that = getType().cast(o);
		
			if (!Objects.equals(isin, _that.getIsin())) return false;
			if (!Objects.equals(nm, _that.getNm())) return false;
			if (!Objects.equals(indx, _that.getIndx())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isin != null ? isin.hashCode() : 0);
			_result = 31 * _result + (nm != null ? nm.hashCode() : 0);
			_result = 31 * _result + (indx != null ? indx.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexIdentification1__1 {" +
				"isin=" + this.isin + ", " +
				"nm=" + this.nm + ", " +
				"indx=" + this.indx +
			'}';
		}
	}

	/*********************** Builder Implementation of IndexIdentification1__1  ***********************/
	class IndexIdentification1__1BuilderImpl implements IndexIdentification1__1.IndexIdentification1__1Builder {
	
		protected String isin;
		protected String nm;
		protected FloatingRateIndex1Code indx;
		
		@Override
		@RosettaAttribute("isin")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isin")
		public String getIsin() {
			return isin;
		}
		
		@Override
		@RosettaAttribute("nm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nm")
		public String getNm() {
			return nm;
		}
		
		@Override
		@RosettaAttribute("indx")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indx")
		public FloatingRateIndex1Code getIndx() {
			return indx;
		}
		
		@RosettaAttribute("isin")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isin")
		@Override
		public IndexIdentification1__1.IndexIdentification1__1Builder setIsin(String _isin) {
			this.isin = _isin == null ? null : _isin;
			return this;
		}
		
		@RosettaAttribute("nm")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nm")
		@Override
		public IndexIdentification1__1.IndexIdentification1__1Builder setNm(String _nm) {
			this.nm = _nm == null ? null : _nm;
			return this;
		}
		
		@RosettaAttribute("indx")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indx")
		@Override
		public IndexIdentification1__1.IndexIdentification1__1Builder setIndx(FloatingRateIndex1Code _indx) {
			this.indx = _indx == null ? null : _indx;
			return this;
		}
		
		@Override
		public IndexIdentification1__1 build() {
			return new IndexIdentification1__1.IndexIdentification1__1Impl(this);
		}
		
		@Override
		public IndexIdentification1__1.IndexIdentification1__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexIdentification1__1.IndexIdentification1__1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIsin()!=null) return true;
			if (getNm()!=null) return true;
			if (getIndx()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexIdentification1__1.IndexIdentification1__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IndexIdentification1__1.IndexIdentification1__1Builder o = (IndexIdentification1__1.IndexIdentification1__1Builder) other;
			
			
			merger.mergeBasic(getIsin(), o.getIsin(), this::setIsin);
			merger.mergeBasic(getNm(), o.getNm(), this::setNm);
			merger.mergeBasic(getIndx(), o.getIndx(), this::setIndx);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndexIdentification1__1 _that = getType().cast(o);
		
			if (!Objects.equals(isin, _that.getIsin())) return false;
			if (!Objects.equals(nm, _that.getNm())) return false;
			if (!Objects.equals(indx, _that.getIndx())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isin != null ? isin.hashCode() : 0);
			_result = 31 * _result + (nm != null ? nm.hashCode() : 0);
			_result = 31 * _result + (indx != null ? indx.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexIdentification1__1Builder {" +
				"isin=" + this.isin + ", " +
				"nm=" + this.nm + ", " +
				"indx=" + this.indx +
			'}';
		}
	}
}
