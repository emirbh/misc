package iso20022.auth030.esma;

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
import iso20022.auth030.esma.meta.InstrumentIdentification6Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Choice between different instrument identification schemes.
 * @version ${project.version}
 */
@RosettaDataType(value="InstrumentIdentification6Choice__1", builder=InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="InstrumentIdentification6Choice__1", model="iso20022", builder=InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1BuilderImpl.class, version="${project.version}")
public interface InstrumentIdentification6Choice__1 extends RosettaModelObject {

	InstrumentIdentification6Choice__1Meta metaData = new InstrumentIdentification6Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * International Securities Identification Number (ISIN). A numbering system designed by the United Nation&#39;s International Organisation for Standardisation (ISO). The ISIN is composed of a 2-character prefix representing the country of issue, followed by the national security number (if one exists), and a check digit. Each country has a national numbering agency that assigns ISIN numbers for securities in that country.
	 */
	String getIsin();

	/*********************** Build Methods  ***********************/
	InstrumentIdentification6Choice__1 build();
	
	InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder toBuilder();
	
	static InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder builder() {
		return new InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InstrumentIdentification6Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InstrumentIdentification6Choice__1> getType() {
		return InstrumentIdentification6Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isin"), String.class, getIsin(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface InstrumentIdentification6Choice__1Builder extends InstrumentIdentification6Choice__1, RosettaModelObjectBuilder {
		InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder setIsin(String isin);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("isin"), String.class, getIsin(), this);
		}
		

		InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of InstrumentIdentification6Choice__1  ***********************/
	class InstrumentIdentification6Choice__1Impl implements InstrumentIdentification6Choice__1 {
		private final String isin;
		
		protected InstrumentIdentification6Choice__1Impl(InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder builder) {
			this.isin = builder.getIsin();
		}
		
		@Override
		@RosettaAttribute("isin")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isin")
		public String getIsin() {
			return isin;
		}
		
		@Override
		public InstrumentIdentification6Choice__1 build() {
			return this;
		}
		
		@Override
		public InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder toBuilder() {
			InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder builder) {
			ofNullable(getIsin()).ifPresent(builder::setIsin);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InstrumentIdentification6Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(isin, _that.getIsin())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isin != null ? isin.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InstrumentIdentification6Choice__1 {" +
				"isin=" + this.isin +
			'}';
		}
	}

	/*********************** Builder Implementation of InstrumentIdentification6Choice__1  ***********************/
	class InstrumentIdentification6Choice__1BuilderImpl implements InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder {
	
		protected String isin;
		
		@Override
		@RosettaAttribute("isin")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isin")
		public String getIsin() {
			return isin;
		}
		
		@RosettaAttribute("isin")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("isin")
		@Override
		public InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder setIsin(String _isin) {
			this.isin = _isin == null ? null : _isin;
			return this;
		}
		
		@Override
		public InstrumentIdentification6Choice__1 build() {
			return new InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Impl(this);
		}
		
		@Override
		public InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIsin()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder o = (InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder) other;
			
			
			merger.mergeBasic(getIsin(), o.getIsin(), this::setIsin);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InstrumentIdentification6Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(isin, _that.getIsin())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isin != null ? isin.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InstrumentIdentification6Choice__1Builder {" +
				"isin=" + this.isin +
			'}';
		}
	}
}
