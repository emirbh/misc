package iso20022.auth030.fca;

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
import iso20022.auth030.fca.meta.DeliveryInterconnectionPoint1Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Identification of the delivery point(s) of market area(s) or the interconnection point of a transportation contract.
 * @version ${project.version}
 */
@RosettaDataType(value="DeliveryInterconnectionPoint1Choice__1", builder=DeliveryInterconnectionPoint1Choice__1.DeliveryInterconnectionPoint1Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="DeliveryInterconnectionPoint1Choice__1", model="iso20022", builder=DeliveryInterconnectionPoint1Choice__1.DeliveryInterconnectionPoint1Choice__1BuilderImpl.class, version="${project.version}")
public interface DeliveryInterconnectionPoint1Choice__1 extends RosettaModelObject {

	DeliveryInterconnectionPoint1Choice__1Meta metaData = new DeliveryInterconnectionPoint1Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identification of delivery/interconnection point or zone as a code.
	 */
	String getCd();
	/**
	 * Identification of delivery/interconnection point or zone in a proprietary format.
	 */
	String getPrtry();

	/*********************** Build Methods  ***********************/
	DeliveryInterconnectionPoint1Choice__1 build();
	
	DeliveryInterconnectionPoint1Choice__1.DeliveryInterconnectionPoint1Choice__1Builder toBuilder();
	
	static DeliveryInterconnectionPoint1Choice__1.DeliveryInterconnectionPoint1Choice__1Builder builder() {
		return new DeliveryInterconnectionPoint1Choice__1.DeliveryInterconnectionPoint1Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DeliveryInterconnectionPoint1Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DeliveryInterconnectionPoint1Choice__1> getType() {
		return DeliveryInterconnectionPoint1Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("cd"), String.class, getCd(), this);
		processor.processBasic(path.newSubPath("prtry"), String.class, getPrtry(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DeliveryInterconnectionPoint1Choice__1Builder extends DeliveryInterconnectionPoint1Choice__1, RosettaModelObjectBuilder {
		DeliveryInterconnectionPoint1Choice__1.DeliveryInterconnectionPoint1Choice__1Builder setCd(String cd);
		DeliveryInterconnectionPoint1Choice__1.DeliveryInterconnectionPoint1Choice__1Builder setPrtry(String prtry);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("cd"), String.class, getCd(), this);
			processor.processBasic(path.newSubPath("prtry"), String.class, getPrtry(), this);
		}
		

		DeliveryInterconnectionPoint1Choice__1.DeliveryInterconnectionPoint1Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of DeliveryInterconnectionPoint1Choice__1  ***********************/
	class DeliveryInterconnectionPoint1Choice__1Impl implements DeliveryInterconnectionPoint1Choice__1 {
		private final String cd;
		private final String prtry;
		
		protected DeliveryInterconnectionPoint1Choice__1Impl(DeliveryInterconnectionPoint1Choice__1.DeliveryInterconnectionPoint1Choice__1Builder builder) {
			this.cd = builder.getCd();
			this.prtry = builder.getPrtry();
		}
		
		@Override
		@RosettaAttribute("cd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cd")
		public String getCd() {
			return cd;
		}
		
		@Override
		@RosettaAttribute("prtry")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prtry")
		public String getPrtry() {
			return prtry;
		}
		
		@Override
		public DeliveryInterconnectionPoint1Choice__1 build() {
			return this;
		}
		
		@Override
		public DeliveryInterconnectionPoint1Choice__1.DeliveryInterconnectionPoint1Choice__1Builder toBuilder() {
			DeliveryInterconnectionPoint1Choice__1.DeliveryInterconnectionPoint1Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DeliveryInterconnectionPoint1Choice__1.DeliveryInterconnectionPoint1Choice__1Builder builder) {
			ofNullable(getCd()).ifPresent(builder::setCd);
			ofNullable(getPrtry()).ifPresent(builder::setPrtry);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DeliveryInterconnectionPoint1Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(cd, _that.getCd())) return false;
			if (!Objects.equals(prtry, _that.getPrtry())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cd != null ? cd.hashCode() : 0);
			_result = 31 * _result + (prtry != null ? prtry.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DeliveryInterconnectionPoint1Choice__1 {" +
				"cd=" + this.cd + ", " +
				"prtry=" + this.prtry +
			'}';
		}
	}

	/*********************** Builder Implementation of DeliveryInterconnectionPoint1Choice__1  ***********************/
	class DeliveryInterconnectionPoint1Choice__1BuilderImpl implements DeliveryInterconnectionPoint1Choice__1.DeliveryInterconnectionPoint1Choice__1Builder {
	
		protected String cd;
		protected String prtry;
		
		@Override
		@RosettaAttribute("cd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cd")
		public String getCd() {
			return cd;
		}
		
		@Override
		@RosettaAttribute("prtry")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prtry")
		public String getPrtry() {
			return prtry;
		}
		
		@RosettaAttribute("cd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cd")
		@Override
		public DeliveryInterconnectionPoint1Choice__1.DeliveryInterconnectionPoint1Choice__1Builder setCd(String _cd) {
			this.cd = _cd == null ? null : _cd;
			return this;
		}
		
		@RosettaAttribute("prtry")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("prtry")
		@Override
		public DeliveryInterconnectionPoint1Choice__1.DeliveryInterconnectionPoint1Choice__1Builder setPrtry(String _prtry) {
			this.prtry = _prtry == null ? null : _prtry;
			return this;
		}
		
		@Override
		public DeliveryInterconnectionPoint1Choice__1 build() {
			return new DeliveryInterconnectionPoint1Choice__1.DeliveryInterconnectionPoint1Choice__1Impl(this);
		}
		
		@Override
		public DeliveryInterconnectionPoint1Choice__1.DeliveryInterconnectionPoint1Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DeliveryInterconnectionPoint1Choice__1.DeliveryInterconnectionPoint1Choice__1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCd()!=null) return true;
			if (getPrtry()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DeliveryInterconnectionPoint1Choice__1.DeliveryInterconnectionPoint1Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DeliveryInterconnectionPoint1Choice__1.DeliveryInterconnectionPoint1Choice__1Builder o = (DeliveryInterconnectionPoint1Choice__1.DeliveryInterconnectionPoint1Choice__1Builder) other;
			
			
			merger.mergeBasic(getCd(), o.getCd(), this::setCd);
			merger.mergeBasic(getPrtry(), o.getPrtry(), this::setPrtry);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DeliveryInterconnectionPoint1Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(cd, _that.getCd())) return false;
			if (!Objects.equals(prtry, _that.getPrtry())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cd != null ? cd.hashCode() : 0);
			_result = 31 * _result + (prtry != null ? prtry.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DeliveryInterconnectionPoint1Choice__1Builder {" +
				"cd=" + this.cd + ", " +
				"prtry=" + this.prtry +
			'}';
		}
	}
}
